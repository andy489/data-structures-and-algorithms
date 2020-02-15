#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define MAX 1024

vector<vector<pair<int, int>>>adj;
vector<vector<bool>>used(MAX, vector<bool>(MAX));

void bfs(int s) {
    queue<pair<int, int>>q;
    q.emplace(s, 0);

    while (!q.empty()) {
        int ver = q.front().first;
        int res_or = q.front().second;
        used[ver][res_or] = true;
        q.pop();
        for (const auto& child : adj[ver]) {
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
    int n, m, u, v, w, s, e;
    adj.resize(n+1);
    cin >> n >> m;
    while (m--) {
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }
    cin >> s >> e;
    bfs(s);
    int ans(-1), i(0);
    for (;i < MAX;++i) {
        if (used[e][i]) {
            ans = i;
            break;
        }
    }
    cout << ans;
    return 0;
}
