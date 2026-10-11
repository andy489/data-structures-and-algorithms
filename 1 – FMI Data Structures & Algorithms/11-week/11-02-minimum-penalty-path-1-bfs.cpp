// https://www.hackerrank.com/contests/101hack34/challenges/beautiful-path/problem

#include <iostream>
#include <vector>
#include <queue>

using namespace std;
const int MAX = 1 << 10;

vector<vector<pair<int, int>>> adj;
vector<vector<bool>> used;

void bfs(int s) {
    used.assign(MAX, vector<bool>(MAX, false));
    
    queue<pair<int, int>> q;
    q.emplace(s, 0);

    while (!q.empty()) {
        auto curr = q.front();
        q.pop();

        int ver = curr.first;
        int res_or = curr.second;

        used[ver][res_or] = true;

        for (const auto &child : adj[ver]) {
            int to = child.first;
            int add = child.second;

            if (!used[to][add | res_or]) {
                used[to][add | res_or] = true;
                q.emplace(to, add | res_or);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;

        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }

    int s, e;
    cin >> s >> e;

    bfs(s);

    int ans = -1;

    for (int i = 0; i < MAX; ++i) {
        if (used[e][i]) {
            ans = i;
            break;
        }
    }

    cout << ans;

    return 0;
}