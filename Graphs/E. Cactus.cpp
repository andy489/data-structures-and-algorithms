// github.com/andy489

// https://codeforces.com/contest/231/problem/E

#include <cstdio>
#include <cmath>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 100001;
int MOD = 1000000007, n, u, v, m, L[MAX], N[MAX], C[MAX], ndfs, comp;
vector<int> adj[MAX], tree[MAX];

void tarjan(int u, int par = -1) {
    L[u] = N[u] = ++ndfs;
    for (const auto &x: adj[u]) {
        if (!N[x]) {
            tarjan(x, u);
            L[u] = min(L[u], L[x]);
        } else if (x != par)
            L[u] = min(L[u], L[x]);
    }
}

bool is_bridge(int a, int b) {
    if (N[a] > N[b])
        swap(a, b);
    return N[a] < L[b];
}

int cont[MAX];

void bfs() {
    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (!C[i]) {
            q.push(i);
            C[i] = comp;
            cont[comp]++;
            while (!q.empty()) {
                u = q.front();
                q.pop();
                for (const auto &v:adj[u]) {
                    if (!is_bridge(u, v) && !C[v]) {
                        C[v] = comp;
                        cont[comp]++;
                        q.push(v);
                    } else if (C[v]) {
                        tree[C[u]].push_back(C[v]);
                        tree[C[v]].push_back(C[u]);
                    }
                }
            }
            comp++;
        }
    }
}

int dp[MAX][18], cant[MAX], num[MAX], level[MAX];

void dfs(int nodo) {
    num[ndfs++] = nodo;
    int x;
    for (int i = tree[nodo].size() - 1; i >= 0; i--) {
        x = tree[nodo][i];
        if (!level[x]) {
            level[x] = level[nodo] + 1;
            cant[x] = cant[nodo];
            if (cont[x] > 1)
                cant[x]++;
            dfs(x);
            dp[x][0] = nodo;
        }
    }
}

void built_lca() {
    for (int i = 0; i < ndfs; i++) {
        int x = num[i];
        int j = 1;
        while (j < 18 && dp[x][j - 1] != -1) {
            dp[x][j] = dp[dp[x][j - 1]][j - 1];
            j++;
        }
    }
}

int query(int a, int b) {
    if (level[b] < level[a])
        swap(a, b);
    int j = 17;
    while (level[b] > level[a]) {
        if (dp[b][j] != -1 && level[dp[b][j]] >= level[a])
            b = dp[b][j];
        j--;
    }
    if (a == b)
        return a;
    j = 17;
    while (j >= 0) {
        if (dp[a][j] != dp[b][j]) {
            a = dp[a][j];
            b = dp[b][j];
        }
        j--;
    }
    return dp[a][0];
}

int po[MAX];

int main() {
    scanf("%d%d", &n, &m);

    po[0] = 1;

    for (int i = 1; i <= n; ++i)
        po[i] = (po[i - 1] * 2) % MOD;

    while (m--) {
        scanf("%d%d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    tarjan(1);
    ndfs = 0;
    comp = 1;
    bfs();
    level[1] = 1;
    if (cont[1] > 1)
        cant[1] = 1;
    memset(dp, -1, sizeof(dp));
    dfs(1);
    built_lca();
    int q;
    scanf("%d", &q);
    while (q--) {
        scanf("%d%d", &u, &v);
        int lca = query(C[u], C[v]);
        int x = cant[C[u]] + cant[C[v]] - 2 * cant[lca];
        if (cont[lca] > 1)
            x++;
        printf("%d\n", po[x]);
    }
    return 0;
}
