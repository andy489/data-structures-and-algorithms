// https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303

#include <cstdio>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <string>

using namespace std;

int n;
unordered_map<string, vector<string>> adj;
unordered_set<string> visited;
vector<string> route;

bool dfs(const string &start) {
    visited.insert(start);
    route.push_back(start);

    for (const string &city: adj[start]) {
        if (city == route[0]) {
            route.push_back(city);
            return true;
        }

        if (!visited.count(city) && dfs(city)) {
            return true;
        }
    }
    route.pop_back();
    return false;
}

void init(int m) {
    char from[10], to[10];
    while (m--) {
        scanf("%s %s", from, to);
        adj[from].push_back(to);
    }
}

int main() {
    int m;
    scanf("%d %d", &n, &m);
    
    init(m);

    char start[10];
    scanf("%s", start);

    if (dfs(start)) {
        for (const string &city: route) {
            printf("%s ", city.c_str());
        }
    } else {
        printf("-1");
    }

    return 0;
}
