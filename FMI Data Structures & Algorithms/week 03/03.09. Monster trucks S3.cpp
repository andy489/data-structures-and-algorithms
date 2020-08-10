// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/monster-trucks

#include <cstdio>
#include <algorithm>

using namespace std;

const int mxN = 50005;

long long n, l = -10000, r = 10000, m, A[mxN], B[mxN];

long long cost(long long h) {
    long long res = 0;
    int i(0);
    for (; i < n; ++i)
        res += abs(A[i] - h) * B[i];
    return res;
}

int main() {
    scanf("%lld", &n);
    int i(0);
    for (; i < n; ++i)
        scanf("%lld%lld", &A[i], &B[i]);

    while (l + 1 < r) {
        m = (l + r) / 2;

        if (cost(m) <= cost(m + 1))
            r = m;
        else
            l = m;
    }
    return printf("%lld", min(cost(l), cost(r))), 0;
}
