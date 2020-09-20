// github.com/andy489

// https://codeforces.com/contest/872/problem/B

#include <stdio.h>

int n;

int st[100000][17], log[100000];

int min(int a, int b) {
    return a > b ? b : a;
}

int max(int a, int b) {
    return a > b ? a : b;
}

void build(){
    int K(log[n]);
    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i)
            st[i][j] = min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
}

int RMQ(int L, int R) {
    int j(log[R - L + 1]);
    return min(st[L][j], st[R - (1 << j) + 1][j]);
}

int main() {
    int k;
    scanf("%d %d", &n, &k);

    log[1] = 0;
    for (int i = 2; i <= n; ++i) {
        log[i] = log[i / 2] + 1;
    }

    int mx = -1e9, mn = 1e9;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &st[i][0]);
        mx = max(mx, st[i][0]);
        mn = min(mn, st[i][0]);
    }

    if (k == 1)
        printf("%d", mn);
    else if (k > 2)
        printf("%d", mx);
    else {
        build();

        int maxi(-1e9);
        for (int i = 0; i < n - 1; ++i) {
            int l = RMQ(0, i);
            int r = RMQ(i + 1, n - 1);
            maxi = max(maxi,max(l,r));
        }
        printf("%d", maxi);
    }
    return 0;
}
