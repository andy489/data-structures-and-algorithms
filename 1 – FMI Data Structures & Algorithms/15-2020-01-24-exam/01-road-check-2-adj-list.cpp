// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<unordered_map<int, int>> adj(n, unordered_map<int, int>());

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;
        adj[u][v] = w;
        adj[v][u] = w;
    }

    int k;
    cin >> k;

    vector<int> path(k);

    for (int i = 0; i < k; ++i) {
        cin >> path[i];
    }

    int cost = 0;
    for (int i = 0; i < k - 1; ++i) {
        if (adj[path[i]].count(path[i + 1])) {
            cost += adj[path[i]][path[i + 1]];
        } else {
            cost = -1;
            break;
        }
    }

    cout << cost;

    return 0;
}
