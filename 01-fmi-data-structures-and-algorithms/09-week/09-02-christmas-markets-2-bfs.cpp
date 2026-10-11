// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <cstdio>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <queue>
#include <stack>

using namespace std;

int n;
char start[10];
unordered_map<string, vector<string>> adj;
unordered_set<string> visited;
unordered_map<string, string> parent;
stack<string> shortest_route_reversed;

bool bfs(const string &u) {
    visited.insert(u);

    queue<string> q;
    q.push(u);

    while (!q.empty()) {
        string current_city = q.front();
        q.pop();

        for (const auto &city : adj[current_city]) {
            if (!visited.count(city)) {
                visited.insert(city);
                q.push(city);
                
                parent[city] = current_city;
                continue;
            }

            if (city == u) {
                parent[city] = current_city;
                return true;
            }
        }
    }
    return false;
}

void init(int m) {
    char city1[10], city2[10];

    while (m--) {
        scanf("%s %s", city1, city2);
        adj[city1].push_back(city2);
    }

    scanf("%s", start);
}

void extract_route() {
    shortest_route_reversed.push(start);
    string traversal = start;

    while (parent[traversal] != start) {
        traversal = parent[traversal];
        shortest_route_reversed.push(traversal);
    }

    shortest_route_reversed.push(start);
}

void display_route() {
    while (!shortest_route_reversed.empty()) {
        printf("%s ", shortest_route_reversed.top().c_str());
        shortest_route_reversed.pop();
    }
}

int main() {
    int m;
    scanf("%d %d", &n, &m);

    init(m);

    if (bfs(start)) {
        extract_route();
    } else {
        return printf("-1"), 0;
    }

    return display_route(), 0;
}
