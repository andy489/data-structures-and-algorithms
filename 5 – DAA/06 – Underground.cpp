#include <cstdio>
#include <vector>

using namespace std;

#define s2(a, b) scanf("%d%d", &a,&b)
#define s3(a, b, c) scanf("%d%d%d", &a,&b,&c)

#define eb emplace_back
#define f first
#define s second
typedef pair<int, int> pii;

int n, m, max_lvl;

const int MXN = 1e5 + 5;

vector<pii> edges[MXN];
int par[MXN], r[MXN];

void initDSU() {
    for (int i = 0; i < n; ++i) {
        par[i] = i;
    }
}

int find(int v) {
    if (v == par[v]) {
        return v;
    }

    return find(par[v]);
}

void uni(int u, int v) {
    if (r[u] < r[v]) {
        swap(u, v);
    }

    par[v] = u;

    if (r[u] == r[v]) {

    }
    ++r[u];
}

int add_edges(int ans = 0) {
    initDSU();

    for (int i = 1; i < max_lvl; ++i)
        for (const auto &e:edges[i]) {
            int u = find(e.f);
            int v = find(e.s);

            if (u == v) {
                return ans = i;
            }

            uni(u, v);
        }
    return ans;
}

int main() {
    s2(n, m);
    int u, v, lvl;

    for (int i = 0; i < m; ++i) {
        s3(u, v, lvl);
        edges[lvl].eb(u, v);
        max_lvl = max(lvl, max_lvl);
    }

    printf("%d\n", add_edges());

    return 0;
}
