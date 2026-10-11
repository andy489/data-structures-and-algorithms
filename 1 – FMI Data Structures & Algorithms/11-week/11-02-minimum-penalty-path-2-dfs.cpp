// https://www.hackerrank.com/contests/101hack34/challenges/beautiful-path/problem

#include <iostream>
#include <vector>

using namespace std;
#define N 1024

vector<pair<int, int> > adj[N];
int used[N][N];

void dfs(int a, int b) {
    used[a][b] = true;
    
    for (const auto &child:adj[a]) {
        int to = child.first;
        int cost = child.second;
        
        cost |= b;
        
        if (!used[to][cost]) {
            dfs(to, cost);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;

        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }

    int s, e;
    cin >> s >> e;
    dfs(s, 0);

    int ans = -1;

    for (int i = 0; i < N; ++i) {
        if (used[e][i]) {
            ans = i;
            break;
        }
    }

    cout << ans;

    return 0;
}
