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
stack<string> shortestRouteReversed;

bool bfs(const string &start) {
    visited.insert(start);

    queue<string> Q;
    Q.push(start);

    while (!Q.empty()) {
        string currentCity = Q.front();
        Q.pop();

        for (const auto &city : adj[currentCity]) {
            if (!visited.count(city)) {
                visited.insert(city);
                Q.push(city);
                parent[city] = currentCity;
                continue;
            }

            if (city == start) {
                parent[city] = currentCity;
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
    shortestRouteReversed.push(start);
    string traversal = start;
    
    while (parent[traversal] != start) {
        traversal = parent[traversal];
        shortestRouteReversed.push(traversal);
    }
    shortestRouteReversed.push(start);
}

void display_route() {
    while (!shortestRouteReversed.empty()) {
        printf("%s ", shortestRouteReversed.top().c_str());
        shortestRouteReversed.pop();
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
