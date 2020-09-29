// github.com/andy489

// https://codeforces.com/contest/231/problem/E

#include <stdio.h>
#include <vector>
#include <list>
#include <stack>

#define pb push_back

using namespace std;

const int MOD = 1e9 + 7;

int n, m, timer, color, N, K;

vector<list<int>> adj, newAdj;
vector<int> tin, low, cycleColor, dep, dfsIn, sum, sz, mult, flog;

stack<int> s;

vector<vector<int>> st;

void init() {
    scanf("%d%d", &n, &m);
    adj.resize(n + 1);
    int u, v;
    while (m--) {
        scanf("%d%d", &u, &v);
        adj[u].pb(v);
        adj[v].pb(u);
    }
    tin.resize(n + 1);
    low.resize(n + 1);
    cycleColor.resize(n + 1);
    sz.resize(n + 1);
}

void tarjan(int u = 1, int p = 0) {
    tin[u] = low[u] = ++timer;
    s.push(u);
    for (const int &child: adj[u]) {
        if (child == p)
            continue;
        if (tin[child])
            low[u] = min(low[u], tin[child]);
        else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);
        }

    }
    if (low[u] == tin[u]) {
        int v;
        color++;
        do {
            v = s.top(), s.pop();
            cycleColor[v] = color;
            ++sz[color];
        } while (u != v);
    }
}

void squeeze() {
    newAdj.resize(n + 1);

    for (int u = 1; u <= n; ++u) {
        for (const int &child: adj[u]) {
            int a = cycleColor[u], b = cycleColor[child];
            if (a ^ b)
                newAdj[cycleColor[u]].pb(cycleColor[child]);
        }
    }

    dep.resize(n + 1);
    dfsIn.resize(n + 1);
    timer = 0;
    sum.resize(n + 1);
    flog.resize(2 * n);
}

void dp() {
    for (int i = 1; i <= color; ++i)
        sum[i] = sz[i] > 1;

    for (int i = 2; i < 2 * n; ++i)
        flog[i] = flog[i >> 1] + 1;

    K = flog[2 * n - 1];
    N = 2 * n - 1;
    st.assign(K + 1, vector<int>(N));
}

void dfs(int u = 1, int p = 0) {
    dep[u] = dep[p] + 1;
    st[0][++timer] = u;
    sum[u] += sum[p];
    dfsIn[u] = timer;

    for (const int &child: newAdj[u]) {
        if (child == p)
            continue;
        dfs(child, u);
        st[0][++timer] = u;
    }
}

void build() {
    for (int j = 1; j <= K; ++j)
        for (int i = 1; i + (1 << j) <= timer; ++i) {
            int a = st[j - 1][i];
            int b = st[j - 1][i + (1 << (j - 1))];
            st[j][i] = (dep[a] < dep[b] ? a : b);
        }
}

void precalc() {
    mult.resize(n + 1);
    mult[0] = 1;
    for (int i = 1; i <= n; ++i)
        mult[i] = 2LL * mult[i - 1] % MOD;
}

int LCA(int u, int v) {
    int L = dfsIn[u], R = dfsIn[v];
    if (L > R)swap(L, R);
    int k = flog[R - L + 1];
    int a = st[k][L], b = st[k][R - (1 << k) + 1];
    return (dep[a] < dep[b] ? a : b);
}

void solve() {
    int q, u, v, lca;
    scanf("%d", &q);
    while (q--) {
        scanf("%d%d", &u, &v);
        u = cycleColor[u];
        v = cycleColor[v];
        lca = LCA(u, v);
        printf("%d\n", mult[sum[u] + sum[v] - (sum[lca] << 1) + (sz[lca] > 1)]);
    }
}

int main() {
    return init(), tarjan(), squeeze(), dp(), dfs(), build(), precalc(), solve(), 0;
}
