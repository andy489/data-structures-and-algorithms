// https://codeforces.com/contest/231/problem/E

#include <stdio.h>
#include <string.h>
#include <cmath>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 1e5 + 1, MOD = 1e9 + 7;

int n, tin[MAX], low[MAX], C[MAX], timer, comp;
int cont[MAX], po[MAX];
int dp[MAX][18], cant[MAX], num[MAX], level[MAX];

vector<int> adj[MAX], tree[MAX];

void tarjan(int u = 1, int par = -1) {
    tin[u] = low[u] = ++timer;

    for (const auto &x: adj[u]) {
        if (!tin[x]) {
            tarjan(x, u);
            low[u] = min(low[u], low[x]);
        } else if (x != par) {
            low[u] = min(low[u], low[x]);
        }
    }
}

bool is_bridge(int a, int b) {
    if (tin[a] > tin[b]) {
        swap(a, b);
    }

    return tin[a] < low[b];
}

void bfs() {
    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (!C[i]) {
            q.push(i);
            C[i] = comp;
            cont[comp]++;

            int u;
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

void dfs(int node = 1) {
    num[timer++] = node;

    int x;
    for (int i = (int) tree[node].size() - 1; i >= 0; i--) {
        x = tree[node][i];

        if (!level[x]) {
            level[x] = level[node] + 1;
            cant[x] = cant[node];

            if (cont[x] > 1) {
                cant[x]++;
            }

            dfs(x);
            dp[x][0] = node;
        }
    }
}

void built_lca() {
    for (int i = 0; i < timer; i++) {
        int x = num[i];
        int j = 1;

        while (j < 18 && dp[x][j - 1] != -1) {
            dp[x][j] = dp[dp[x][j - 1]][j - 1];
            j++;
        }
    }
}

int query(int a, int b) {
    if (level[b] < level[a]) {
        swap(a, b);
    }

    int j = 17;

    while (level[b] > level[a]) {
        if (dp[b][j] != -1 && level[dp[b][j]] >= level[a]) {
            b = dp[b][j];
        }
        j--;
    }

    if (a == b) {
        return a;
    }

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

int main() {
    int m;
    scanf("%d%d", &n, &m);

    po[0] = 1;

    for (int i = 1; i <= n; ++i) {
        po[i] = (po[i - 1] * 2) % MOD;
    }

    int u, v;
    while (m--) {
        scanf("%d%d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    tarjan();

    timer = 0;
    comp = 1;

    bfs();

    level[1] = 1;
    if (cont[1] > 1) {
        cant[1] = 1;
    }

    memset(dp, -1, sizeof(dp));

    dfs();
    built_lca();

    int q;
    scanf("%d", &q);

    while (q--) {
        scanf("%d%d", &u, &v);
        int lca = query(C[u], C[v]);
        int x = cant[C[u]] + cant[C[v]] - 2 * cant[lca];
        if (cont[lca] > 1) {
            x++;
        }

        printf("%d\n", po[x]);
    }

    return 0;
}
