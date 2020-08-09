// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/strawberries-sda

#include <cstdio>

using namespace std;

const int mxN = 100005;

long long n, q, x, l, r, m, A[mxN];

int main() {
    scanf("%lld", &n);
    int i(0);
    for (; i < n; ++i) {
        scanf("%lld", &A[i]);
        A[i] += (i > 0 ? A[i - 1] : 0);
    }

    scanf("%lld", &q);

    while (q--) {
        scanf("%lld", &x);

        l = 0;
        r = n - 1;

        while (l != r) {
            m = (l + r) / 2;
            if (A[m] < x)
                l = m + 1;
            else
                r = m;
        }
        printf("%lld\n", l + 1);
    }
    return 0;
}
