// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2299

#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <set>

using namespace std;

int V, E, k, a, b, sz, lvl;

vector<list<int>> adj;
vector<bool> vis;
set<int> ans;

void bfs(int u) {
    queue<int> Q;
    Q.push(u);
    vis[u] = true;
    sz = 1;
    while (!Q.empty()) {
        auto curr = Q.front();
        Q.pop();

        --sz;
        for (const auto &child : adj[curr]) {
            if (!vis[child]) {
                if (lvl == k - 1)
                    ans.insert(child);
                Q.push(child);
                vis[child] = true;
            }
        }

        if (!sz) {
            sz = Q.size();
            ++lvl;
            if (lvl >= k)
                return;
        }
    }
}

int main() {
    cin >> V >> E >> k;

    adj.assign(V + 1, list<int>());
    vis.assign(V + 1, 0);

    while (E--) {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    bfs(V);

    if (k == 0)
        cout << V;
    else if (!ans.size())
        cout << "-1";
    else
        for (const auto &x : ans)
            cout << x << ' ';
    return 0;
}
