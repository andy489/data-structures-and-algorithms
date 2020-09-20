// github.com/andy489

// https://codeforces.com/contest/872/problem/B

#include <stdio.h>

using namespace std;

int min(int a, int b) {
    return a > b ? b : a;
}

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    int n, k, a, i(0), f, l;
    scanf("%d%d", &n, &k);

    int mini(1e9), maxi(-1e9);
    for (; i < n; ++i) {
        scanf("%d", &a);
        if (!i) f = a; // first
        if (i == n - 1) l = a; // last
        mini = min(mini, a);
        maxi = max(maxi, a);
    }

    int ans;

    switch (k) {
        case 1:
            ans = mini;
            break;
        case 2:
            ans = max(f,l);
            break;
        default:
            ans = maxi;
    }

    return printf("%d", ans), 0;
}
