// https://www.hackerrank.com/contests/test6-sda/challenges/challenge-1761/problem

#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

vector<set<int>> adj;

vector<int> mark;

int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1, set<int>());
    mark.resize(n + 1, 0);

    int u, v;
    while (m--) {
        cin >> u >> v;
        adj[u].insert(v);
        adj[v].insert(u);
    }

    queue<int> q; // leaves

    for (int i = 1; i <= n; ++i) {
        if (adj[i].size() < 2) {
            q.push(i);
        }
    }

    int removed_edges_cnt = 0;
    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        if (adj[curr].empty()) {
            continue;
        }

        int other = *adj[curr].begin();
        adj[other].erase(curr);

        if (adj[other].size() < 2) {
            q.push(other); // new leave
        }

        if (mark[curr]) {
            ++removed_edges_cnt;
        } else {
            mark[other] ^= 1;
        }
    }

    cout << removed_edges_cnt;

    return 0;
}