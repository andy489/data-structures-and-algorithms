// https://www.hackerrank.com/contests/practice-3-sda/challenges/strawberries-sda

#include <cstdio>

using namespace std;

const int MAX = 1e5;

long long A[MAX];

int main() {
    int n;
    scanf("%d", &n);

    for (int i =0; i < n; ++i) {
        scanf("%lld", &A[i]);
        A[i] += (i > 0 ? A[i - 1] : 0);
    }

    int q;
    scanf("%d", &q);

    long long x;

    int l, r, m;
    while (q--) {
        scanf("%lld", &x);

        l = 0;
        r = n - 1;

        while (l != r) {
            m = (l + r) / 2;

            if (A[m] < x) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }

        printf("%d\n", l + 1);
    }

    return 0;
}
