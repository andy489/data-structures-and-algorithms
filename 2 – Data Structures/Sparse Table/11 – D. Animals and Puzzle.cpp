// https://codeforces.com/contest/713/problem/D

#include <cstdio>
#include <algorithm>

using namespace std;

const int mxN = 1e3;

int n, m, arr[mxN][mxN], log2[mxN + 1], dp[mxN][mxN], st[9 + 1][9 + 1][mxN][mxN], x1, y1, x2, y2;

int query(int a, int b, int c, int d) {
    int x = log2[c - a];
    int y = log2[d - b];
    
    return max(max(st[x][y][a][b], st[x][y][c + 1 - (1 << x)][b]),
               max(st[x][y][a][d + 1 - (1 << y)], st[x][y][c + 1 - (1 << x)][d + 1 - (1 << y)]));
}

int bin_search(int l, int r) {
    int mid;
    while (l <= r) {
        mid = l + (r - l) / 2;

        if (query(x1, y1, x2 - mid + 1, y2 - mid + 1) >= mid) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }

    return r;
}

void init() {
    for (int i = 2; i <= mxN; ++i) {
        log2[i] = log2[i >> 1] + 1;
    }

    scanf("%d %d", &n, &m);

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            scanf("%d", &arr[i][j]);
        }
    }
}

void build() {
    for (int i = n - 1; i >= 0; --i) {
        for (int j = m - 1; j >= 0; --j) {
            dp[i][j] = arr[i][j] ? (i == n - 1 || j == m - 1) ?
                                   arr[i][j] : 1 + min({dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]}) : 0;
        }
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            st[0][0][i][j] = dp[i][j];
        }
    }

    for (int y = 1; y <= 9; ++y) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m - (1 << y); ++j) {
                st[0][y][i][j] = max(st[0][y - 1][i][j], st[0][y - 1][i][j + (1 << (y - 1))]);
            }
        }
    }

    for (int x = 1; x <= 9; ++x) {
        for (int y = 0; y <= 9; ++y) {
            for (int i = 0; i <= n - (1 << x); ++i) {
                for (int j = 0; j <= m - (1 << y); ++j) {
                    st[x][y][i][j] = max(st[x - 1][y][i][j], st[x - 1][y][i + (1 << (x - 1))][j]);
                }
            }
        }
    }
}

void solve() {
    int q;
    scanf("%d", &q);

    while (q--) {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        --x1, --y1, --x2, --y2;
        printf("%d\n", bin_search(0, min(x2 - x1, y2 - y1) + 1));
    }
}

int main() {
    init();
    build();
    solve();

    return 0;
}
