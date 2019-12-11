#include <cstdio>
#include <algorithm>

using namespace std;

const int MAXN = 50005;

long long n, l = -10000, r = 10000, m, A[MAXN], B[MAXN];

long long cost(long long h) {
    long long res = 0;

    for (int i = 0; i < n; i++) {
        res += abs(A[i] - h) * B[i];
    }

    return res;
}

int main() {
    scanf("%lld", &n);

    for (int i = 0; i < n; i++) {
        scanf("%lld%lld", &A[i], &B[i]);
    }

    while (l + 1 < r) {
        m = (l + r) / 2;

        if (cost(m) <= cost(m + 1)) {
            r = m;
        } else {
            l = m;
        }
    }

    printf("%lld\n", min(cost(l), cost(r)));

    return 0;
}
