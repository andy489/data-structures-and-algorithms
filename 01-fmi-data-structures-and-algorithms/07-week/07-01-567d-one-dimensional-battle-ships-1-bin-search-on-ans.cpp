// https://codeforces.com/contest/567/problem/D

#include <cstdio>

const int MAX = 2e5 + 5;

int move[MAX], mark[MAX], n, k, a, m;

int valid(int x) {
    int cons = 0;
    int cur = 0;

    for (int i = 1; i <= n; ++i) {
        mark[i] = 0;
    }

    for (int i = 1; i <= x; ++i) {
        ++mark[move[i]];
    }

    for (int i = 1; i <= n; ++i) {
        if (!mark[i]) {
            ++cons;
        } else {
            cons = 0;
        }

        if (cons == a) {
            ++cur;
            cons = -1;
        }
    }

    if (cur >= k) {
        return 1;
    }

    return 0;
}

int bin_search_on_ans(int l, int r) {
    int mid = (l + r) >> 1;
    if (l >= r) {
        return l;
    }

    if (!valid(mid)) {
        return bin_search_on_ans(l, mid);
    } else {
        return bin_search_on_ans(mid + 1, r);
    }
}

int main() {
    scanf("%d %d %d %d", &n, &k, &a, &m);

    for (int i = 1; i <= m; ++i) {
        scanf("%d", &move[i]);
    }

    if (valid(m) == 1) {
        printf("-1");
    } else {
        printf("%d", bin_search_on_ans(1, m));
    }

    return 0;
}
