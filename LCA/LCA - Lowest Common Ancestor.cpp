// github.com/andy489

// https://www.spoj.com/problems/LCA/

#include <iostream>
#include <vector>
#include <list>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define pb push_back

int timer, n, N, K;

vector<list<int>> adj;
vector<int> first, euler, dep, flog;
vector<vector<int>> st;

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
    dep.assign(n + 1, 0);
    euler.assign(N, 0);
}

void dfs(int u = 1, int p = 0) {
    dep[u] = dep[p] + 1;
    first[u] = timer;
    euler[timer++] = u;
    for (const int &child: adj[u]) {
        if (child == p)
            continue;
        else {
            dfs(child, u);
            euler[timer++] = u;
        }
    }
}

void build() {
    K = flog[N];

    st.assign(K + 1, vector<int>(N));

    for (int i = 0; i < N; ++i)
        st[0][i] = euler[i];

    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= N; ++i) {
            int a = st[j - 1][i], b = st[j - 1][i + (1 << (j - 1))];
            st[j][i] = (dep[a] < dep[b] ? a : b);
        }
}

int LCA(int u, int v) {
    if (u == v)
        return u;
    int L = first[u], R = first[v];
    if (L > R)
        swap(L, R);
    int k = flog[R - L + 1];
    int a = st[k][L], b = st[k][R - (1 << k) + 1];
    return (dep[a] < dep[b] ? a : b);
}

void queries() {
    int q, u, v;
    cin >> q;
    while (q--) {
        cin >> u >> v;
        cout << LCA(u, v) << '\n';
    }

}

void solve() {
    int t;
    cin >> t;
    for (int i = 1; i <= t; ++i) {
        cout << "Case " << i << ":\n";
        init(), dfs(), build(), queries();
        timer = 0;
    }
}

void pre() {
    const int mxN = 1000;
    int sz = mxN << 1;
    flog.resize(sz);
    for (int i = 2; i < sz; ++i)
        flog[i] = flog[i >> 1] + 1;
}

int main() {
    ios;
    return pre(), solve(), 0;
}
