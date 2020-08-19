// github.com/andy489

// https://acm.timus.ru/problem.aspx?space=1&num=1671

#include <stdio.h>

using namespace std;

const int mxN = 100001;

int u[mxN], v[mxN], c[mxN], par[mxN], r[mxN];
// vertex u, vertex v, c - edge number, par - parent, r - rank
bool del[mxN];
// del - removed edge

int find(int x) {
    if (par[x] == x) return x;
    return par[x] = find(par[x]);
}

int unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return 0;
    if (r[x] > r[y]) {
        par[y] = x;
    } else {
        par[x] = y;
        if (r[x] == r[y])
            r[y]++;
    }
    return 1;
}

int main() {
    int n, m, i(1), q, comp;
    scanf("%d%d", &n, &m);

    for (; i <= m; ++i)
        scanf("%d%d", u + i, v + i);

    scanf("%d", &q);

    for (i = 1; i <= q; ++i) {
        scanf("%d", c + i);
        del[c[i]] = true;
    }

    for (i = 1; i <= n; ++i)
        par[i] = i;

    comp = n;
    for (i = 1; i <= m; ++i)
        if (!del[i])
            comp -= unite(u[i], v[i]);

    c[q + 1] = comp;


    for (i = q; i > 1; --i) {
        comp -= unite(u[c[i]], v[c[i]]);
        c[i] = comp;
    }

    for (i = 2; i <= q + 1; ++i)
        printf("%d ", c[i]);

    return 0;
}
