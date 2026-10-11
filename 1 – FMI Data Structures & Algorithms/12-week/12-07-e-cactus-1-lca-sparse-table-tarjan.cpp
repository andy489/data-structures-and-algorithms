// https://codeforces.com/contest/231/problem/E

#include <cstdio>
#include <vector>
#include <list>
#include <stack>

using namespace std;

const int MOD = 1e9 + 7;

int n, timer, color, N, K;

vector<list<int>> adj, compressed_adj;
vector<int> tin, low, cycle_color, dep, dfs_in, sum, comp_size, multiplier, floor_log;

stack<int> dfs_stack;
vector<vector<int>> sparse_table;

void init() {
    int m;
    scanf("%d %d", &n, &m);

    adj.resize(n + 1);
    compressed_adj.resize(n + 1);

    tin.resize(n + 1);
    low.resize(n + 1);

    cycle_color.resize(n + 1);
    comp_size.resize(n + 1);

    int u, v;
    while (m--) {
        scanf("%d %d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
}

void tarjan(int u = 1, int p = 0) {
    tin[u] = low[u] = ++timer;
    dfs_stack.push(u);

    for (int child: adj[u]) {
        if (child == p) {
            continue;
        }

        if (tin[child]) {
            low[u] = min(low[u], tin[child]);
        } else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);
        }
    }

    if (low[u] == tin[u]) {
        color++;

        int v;
        do {
            v = dfs_stack.top();
            dfs_stack.pop();

            cycle_color[v] = color;
            ++comp_size[color];
        } while (u != v);
    }
}

void squeeze_graph() {
    for (int u = 1; u <= n; ++u) {
        for (int child: adj[u]) {
            int a = cycle_color[u];
            int b = cycle_color[child];

            if (a ^ b) {
                compressed_adj[cycle_color[u]].push_back(cycle_color[child]);
            }
        }
    }

    dep.resize(n + 1);
    dfs_in.resize(n + 1);

    timer = 0;

    sum.resize(n + 1);
    floor_log.resize(2 * n);
}

void dynamic_preprocess() {
    for (int i = 1; i <= color; ++i) {
        sum[i] = comp_size[i] > 1;
    }

    for (int i = 2; i < 2 * n; ++i) {
        floor_log[i] = floor_log[i >> 1] + 1;
    }

    K = floor_log[2 * n - 1];
    N = 2 * n - 1;

    sparse_table.assign(K + 1, vector<int>(N));
}

void dfs(int u = 1, int p = 0) {
    dep[u] = dep[p] + 1;
    sparse_table[0][++timer] = u;
    sum[u] += sum[p];
    dfs_in[u] = timer;

    for (int child: compressed_adj[u]) {
        if (child == p) {
            continue;
        }

        dfs(child, u);

        sparse_table[0][++timer] = u;
    }
}

void build_sparse_table() {
    for (int j = 1; j <= K; ++j) {
        for (int i = 1; i + (1 << j) <= timer; ++i) {
            int a = sparse_table[j - 1][i];
            int b = sparse_table[j - 1][i + (1 << (j - 1))];

            sparse_table[j][i] = (dep[a] < dep[b] ? a : b);
        }
    }
}

void pre_process() {
    multiplier.resize(n + 1);
    multiplier[0] = 1;

    for (int i = 1; i <= n; ++i) {
        multiplier[i] = 2LL * multiplier[i - 1] % MOD;
    }
}

int lowest_common_ancestor(int u, int v) {
    int l = dfs_in[u];
    int r = dfs_in[v];

    if (l > r) {
        swap(l, r);
    }

    int k = floor_log[r - l + 1];

    int a = sparse_table[k][l];
    int b = sparse_table[k][r - (1 << k) + 1];

    return (dep[a] < dep[b] ? a : b);
}

void solve() {
    int q, u, v, lca;
    scanf("%d", &q);

    while (q--) {
        scanf("%d%d", &u, &v);

        u = cycle_color[u];
        v = cycle_color[v];

        lca = lowest_common_ancestor(u, v);
        printf("%d\n", multiplier[sum[u] + sum[v] - (sum[lca] << 1) + (comp_size[lca] > 1)]);
    }
}

int main() {
    init();
    tarjan();
    squeeze_graph();
    dynamic_preprocess();
    dfs();
    build_sparse_table();
    pre_process();
    solve();
    return 0;
}
