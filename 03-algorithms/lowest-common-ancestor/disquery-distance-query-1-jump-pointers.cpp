// http://www.spoj.com/problems/DISQUERY/

// Time complexity: <O(n.log(n), log(n))>

#include <iostream>
#include <vector>
#include <list>

using namespace std;

#define pii pair<int,int>
#define pb push_back
#define f first
#define s second

int n, flog; // n <- |V|

vector<list<pii>> adj; // adj <- adjacency list
vector<int> dep, euler_tour; // dep <- depths, euler_tour <- Euler tour
vector<vector<int>> jump, mini, maxi; // jump <- 2^k-th ancestor, mini|maxi <- sparse tables

void fill_jumps(int u) { // fill sparse tables O(log(n))
    int l = (int) euler_tour.size();

    int j = 1;
    int i = 0;

    while (l - j >= 0) {
        jump[u][i++] = euler_tour[l - j];
        j <<= 1;
    }
}

void dfs(int u = 1, int p = 0, int w = 0) { // Euler tour (Depth First Search), O(n)
    dep[u] = dep[p] + 1;

    fill_jumps(u);
    euler_tour.pb(u); // O(1)
    jump[u][0] = p;

    if (p) {
        mini[u][0] = maxi[u][0] = w;
    }

    for (int i = 1; i < flog; ++i) {
        if (jump[u][i - 1]) { // fill sparse tables (dynamic programming)
            maxi[u][i] = max(maxi[u][i - 1], maxi[jump[u][i - 1]][i - 1]);
            mini[u][i] = min(mini[u][i - 1], mini[jump[u][i - 1]][i - 1]);
        } else {
            break;
        }
    }

    for (const auto &child : adj[u]) {
        if (child.f ^ p) {
            dfs(child.f, u, child.s);
            euler_tour.pop_back(); // O(1)
        }
    }
}

void init() {
    cin >> n;

    int m = n;
    while (m > 1) { // flog <- max possible depth
        ++flog;
        m >>= 1;
    }

    adj.resize(n + 1);
    dep.resize(n + 1);
    mini.resize(n + 1, vector<int>(flog, 1e9));
    maxi.resize(n + 1, vector<int>(flog, -1));
    euler_tour.reserve(2 * n - 1); // reserve 2 * n - 1 to guarantee O(1) for push_back
    jump.resize(n + 1, vector<int>(flog, 0));

    int u, v, w;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v >> w;

        adj[u].pb({v, w});
        adj[v].pb({u, w});
    }
}

pii lca(int u, int v) { // O(log(n))
    int ans_mini = static_cast<int>(1e10), ans_maxi = 0;

    if (dep[u] > dep[v]) {
        swap(u, v);
    }

    // traverse with exponential jumps to synchronize depths ot nodes u an v
    for (int i = flog - 1; i >= 0; --i) {
        if (jump[v][i] && dep[jump[v][i]] >= dep[u]) {
            ans_mini = min(ans_mini, mini[v][i]);
            ans_maxi = max(ans_maxi, maxi[v][i]);
            v = jump[v][i];
        }
    }

    if (v == u) {
        return {ans_mini, ans_maxi};
    }

    // jump until reach Lowest Common Ancestor
    for (int i = flog - 1; i >= 0; --i) {
        if (jump[v][i] ^ jump[u][i]) {
            ans_mini = min(ans_mini, min(mini[v][i], mini[u][i]));
            ans_maxi = max(ans_maxi, max(maxi[v][i], maxi[u][i]));

            v = jump[v][i];
            u = jump[u][i];
        }
    }

    ans_mini = min(ans_mini, min(mini[v][0], mini[u][0]));
    ans_maxi = max(ans_maxi, max(maxi[v][0], maxi[u][0]));

    return {ans_mini, ans_maxi};
}

void answer_queries() { // O(q * log(n))
    int q;
    cin >> q;

    int u, v;
    while (q--) {
        cin >> u >> v;
        pii ans = lca(u, v);

        cout << ans.f << ' ' << ans.s << endl;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    init();

    dfs();

    answer_queries();

    return 0;
}
