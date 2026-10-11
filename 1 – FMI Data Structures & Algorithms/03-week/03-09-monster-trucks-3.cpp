// https://www.hackerrank.com/contests/practice-3-sda/challenges/monster-trucks

#include <cstdio>
#include <algorithm>

using namespace std;

const int MAX = 5e4 + 5;

int n;

long long A[MAX], B[MAX];

long long cost(long long h) {
    long long res = 0;

    for (int i = 0; i < n; ++i) {
        res += abs(A[i] - h) * B[i];
    }

    return res;
}

int main() {
    scanf("%d", &n);

    for (int i = 0; i < n; ++i) {
        scanf("%lld%lld", &A[i], &B[i]);
    }

    int l = -1e4;
    int r = 1e4;
    int m;
    
    while (l + 1 < r) {
        m = (l + r) / 2;

        if (cost(m) <= cost(m + 1)) {
            r = m;
        } else {
            l = m;
        }
    }

    printf("%lld", min(cost(l), cost(r)));

    return 0;
}
