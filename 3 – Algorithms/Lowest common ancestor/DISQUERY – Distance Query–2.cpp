// http://www.spoj.com/problems/DISQUERY/

#include <iostream>
#include <vector>

using namespace std;

#define pii pair<int,int>
#define f first
#define s second

const int mxN = 1e5 + 5;
const int k = 17;

vector<pair<int, int>> adj[mxN];
// ancestor[v][k] stores 2^k-th ancestor of vertex v
int ancestor[mxN][k], dep[mxN], mini[mxN][k], maxi[mxN][k];

void dfs(int u = 1, int p = -1, int w = 0) {
    ancestor[u][0] = p;

    if (p != -1) {
        dep[u] = dep[p] + 1;
        mini[u][0] = maxi[u][0] = w;
    }

    for (int i = 1; i < k; ++i) {
        if (ancestor[u][i - 1] != -1) {
            ancestor[u][i] = ancestor[ancestor[u][i - 1]][i - 1];
            maxi[u][i] = max(maxi[u][i - 1], maxi[ancestor[u][i - 1]][i - 1]);
            mini[u][i] = min(mini[u][i - 1], mini[ancestor[u][i - 1]][i - 1]);
        } else {
            break;
        }
    }

    for (const auto &child : adj[u]) {
        if (child.f ^ p) {
            dfs(child.f, u, child.s);
        }
    }
}

pii lca(int u, int v) {
    int ans_mini = 1e9;
    int ans_maxi = -1;

    if (dep[u] > dep[v]) {
        swap(u, v);
    }

    for (int i = k - 1; i >= 0; --i) {
        if (ancestor[v][i] != -1 and dep[ancestor[v][i]] >= dep[u]) {
            ans_mini = min(ans_mini, mini[v][i]);
            ans_maxi = max(ans_maxi, maxi[v][i]);
            v = ancestor[v][i];
        }
    }

    if (v == u) {
        return {ans_mini, ans_maxi};
    }

    for (int i = k - 1; i >= 0; --i) {
        if (ancestor[v][i] != ancestor[u][i]) {
            ans_mini = min(ans_mini, min(mini[v][i], mini[u][i]));
            ans_maxi = max(ans_maxi, max(maxi[v][i], maxi[u][i]));

            v = ancestor[v][i];
            u = ancestor[u][i];
        }
    }

    ans_mini = min(ans_mini, min(mini[v][0], mini[u][0]));
    ans_maxi = max(ans_maxi, max(maxi[v][0], maxi[u][0]));

    return {ans_mini, ans_maxi};
}

int main() {
    int n;
    cin >> n;

    int u, v, w;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v >> w;

        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j < k; ++j) {
            ancestor[i][j] = -1;

            maxi[i][j] = -1;
            mini[i][j] = 1e9;
        }
    }

    dfs();

    int q;
    cin >> q;
    while (q--) {
        cin >> u >> v;

        pii ans = lca(u, v);

        cout << ans.f << ' ' << ans.s << endl;
    }

    return 0;
}