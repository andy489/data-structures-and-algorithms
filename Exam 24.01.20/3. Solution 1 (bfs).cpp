// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2351

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<int> vis;

void bfs(int s) {
    queue<int> Q;
    Q.push(s);
    vis[s] = true;
    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        for (const auto &child:adj[cur]) {
            if (!vis[child]) {
                Q.push(child);
                vis[child] = true;
            }
        }
    }
}

int main() {
    int q, n, m, a, b;
    cin >> q;
    while (q--) {
        cin >> n >> m;
        adj.assign(n, list<int>());
        vis.assign(n, 0);

        while (m--) {
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        int comp(0);

        for (a = 0; a < n; ++a) {
            if (!vis[a]) {
                bfs(a);
                ++comp;
            }
        }
        
        if (comp)
            cout << comp << ' ';
    }
    return 0;
}
