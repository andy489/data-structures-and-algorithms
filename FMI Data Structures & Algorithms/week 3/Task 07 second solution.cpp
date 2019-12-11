#include <cstdio>

using namespace std;

const int MAXN = 100005;

long long n, q, x, l, r, m, A[MAXN];

int main() {
    scanf("%lld", &n);

    for (int i = 0; i < n; i++) {
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

            if (A[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        printf("%lld\n", l + 1);
    }
    return 0;
}
