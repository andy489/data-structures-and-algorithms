#include <cstdio>
#include <vector>

using namespace std;

#define s2(a, b) scanf("%d%d", &a,&b)
#define s3(a, b, c) scanf("%d%d%d", &a,&b,&c)

#define eb emplace_back
#define f first
#define s second
typedef pair<int, int> pii;

int n, m;

const int MXN = 1e5 + 5;

vector<pii> edges[MXN];
int par[MXN], r[MXN];

void initDSU() {
    for (int i = 0; i < n; ++i) par[i] = i;
}

int find(int v) {
    if (v == par[v]) return v;
    return find(par[v]);
}

void uni(int u, int v) {
    if (r[u] < r[v]) swap(u, v);
    par[v] = u;
    if (r[u] == r[v]) ++r[u];
}

int addEdges(int ans = 0) {
    initDSU();
    for (int i = 0; i < n; ++i)
        for (const auto &e:edges[i]) {
            int u = find(e.f), v = find(e.s);
            if (u == v) return ans = i, ans;
            uni(u, v);
        }
    return ans;
}

int main() {
    s2(n, m);
    int u, v, lvl;

    for (int i = 0; i < m; ++i)
        s3(u, v, lvl), edges[lvl].eb(u, v);

    return printf("%d\n", addEdges()), 0;
}
