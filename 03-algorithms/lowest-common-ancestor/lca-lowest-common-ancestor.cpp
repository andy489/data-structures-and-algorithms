// https://www.spoj.com/problems/LCA/

#include <iostream>
#include <vector>
#include <list>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define pb push_back

int timer, n, N, K;

vector<list<int>> adj;
vector<int> first, euler_tour, depth, flog2;
vector<vector<int>> sparse_table;

void init() {
    int m, child;
    cin >> n;
    adj.assign(n + 1, list<int>());

    for (int i = 1; i <= n; ++i) {
        cin >> m;
        while (m--) {
            cin >> child;
            adj[i].pb(child);
            adj[child].pb(i);
        }
    }

    N = 2 * n - 1;
    first.assign(n + 1, 0);
    depth.assign(n + 1, 0);
    euler_tour.assign(N, 0);
}

void dfs(int u = 1, int p = 0) {
    depth[u] = depth[p] + 1;
    first[u] = timer;
    euler_tour[timer++] = u;

    for (const int &child: adj[u]) {
        if (child == p) {
            continue;
        } else {
            dfs(child, u);
            euler_tour[timer++] = u;
        }
    }
}

void build() {
    K = flog2[N];

    sparse_table.assign(K + 1, vector<int>(N));

    for (int i = 0; i < N; ++i) {
        sparse_table[0][i] = euler_tour[i];
    }

    for (int j = 1; j <= K; ++j) {
        for (int i = 0; i + (1 << j) <= N; ++i) {
            int a = sparse_table[j - 1][i], b = sparse_table[j - 1][i + (1 << (j - 1))];

            sparse_table[j][i] = (depth[a] < depth[b] ? a : b);
        }
    }
}

int lca(int u, int v) {
    if (u == v) {
        return u;
    }

    int L = first[u];
    int R = first[v];

    if (L > R) {
        swap(L, R);
    }

    int k = flog2[R - L + 1];
    int a = sparse_table[k][L], b = sparse_table[k][R - (1 << k) + 1];

    return (depth[a] < depth[b] ? a : b);
}

void answer_queries() {
    int q;
    cin >> q;

    int u, v;
    while (q--) {
        cin >> u >> v;

        cout << lca(u, v) << endl;
    }
}

void solve() {
    int t;
    cin >> t;

    for (int i = 1; i <= t; ++i) {
        cout << "Case " << i << ":" << endl;

        init();

        dfs();

        build();

        answer_queries();

        timer = 0;
    }
}

void preprocess_log2() {
    const int mxN = 1000;

    int sz = mxN << 1;

    flog2.resize(sz);

    for (int i = 2; i < sz; ++i) {
        flog2[i] = flog2[i >> 1] + 1;
    }
}

int main() {
    ios;

    preprocess_log2();

    solve();

    return 0;
}
