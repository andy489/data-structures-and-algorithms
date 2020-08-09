// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/cows-sda

#include <cstdio>
#include <algorithm>

using namespace std;
const int mxN = 100005;
long long n, k, l = 1, r, m, s, p, A[mxN];

int main() {
    scanf("%lld%lld", &n, &k);
    int i(0);
    for (; i < n; ++i)
        scanf("%lld", &A[i]);

    sort(A, A + n);
    r = A[n - 1] - A[0];

    while (l != r) {
        m = (l + r + 1) / 2;
        s = A[0];
        p = 1;
        for (i = 1; i < n; ++i)
            if (A[i] - s >= m)
                ++p, s = A[i];
        if (p >= k)
            l = m;
        else
            r = m - 1;
    }
    return printf("%lld", l), 0;
}
