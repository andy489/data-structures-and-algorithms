// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <iostream>
#include <list>
#include <string>
#include <unordered_map>
#include <queue>

using namespace std;

struct Node {
    string name;
    string parent;
    bool visited;
    list<Node *> out;

    Node(string name = "", string parent = "", bool visited = false) :
            name(name), parent(parent), visited(visited) {};

    ~Node() {
        out.clear();
    }
};

bool bfs(const string &start, unordered_map<string, Node *> &um) {
    um[start]->visited = true;
    queue<string> Q;
    Q.push(start);

    while (!Q.empty()) {
        string curr = Q.front();
        Q.pop();
        for (const auto &x : um[curr]->out) {
            if (!x->visited) {
                x->visited = true;
                Q.push(x->name);
                x->parent = curr;
            } else {
                if (x->name == start) {
                    x->parent = curr;
                    return true;
                }
            }
        }
    }
    return false;
}

void freeMap(unordered_map<string, Node *> &um) {
    auto it = um.begin();
    for (;it != um.end(); ++it)
        delete it->second;
}

int main() {
    int n, m;
    cin >> n >> m;

    string city1, city2;

    unordered_map<string, Node *> um;

    while (m--) {
        cin >> city1 >> city2;

        Node *CITY1 = nullptr,
                *CITY2 = nullptr;

        if (!um.count(city1)) {
            CITY1 = new Node(city1);
            um[city1] = CITY1;
        }

        if (!um.count(city2)) {
            CITY2 = new Node(city2);
            um[city2] = CITY2;
        } else {
            CITY2 = um[city2];
        }
        um[city1]->out.push_back(CITY2);
    }

    string start;
    cin >> start;

    list<string> possibleCycle; // this is even the shortest cycle

    if (bfs(start, um)) {
        possibleCycle.push_front(start);
        string traverse = um[start]->parent;
        while (traverse != start) {
            possibleCycle.push_front(um[traverse]->name);
            traverse = um[traverse]->parent;
        }
    } else {
        cout << "-1";
        return freeMap(um), 0;
    }
    possibleCycle.push_front(start);

    for (const auto &x : possibleCycle)
        cout << x << ' ';
    return freeMap(um), 0;
}
