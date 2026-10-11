// https://www.hackerrank.com/contests/practice-3-sda/challenges/strawberries-sda

#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

int main() {
    int n;
    scanf("%d", &n);

    vector<ll> A(n);

    for (int i = 0; i < n; ++i) {
        scanf("%lld", &A[i]);
    }

    for (int i = 1; i < n; ++i) {
        A[i] += A[i - 1];
    }

    int q;
    scanf("%d", &q);

    ll x;
    while (q--) {
        scanf("%lld", &x);

        int res = upper_bound(A.begin(), A.end(), x - 1) - A.begin() + 1;
        printf("%d\n", res);
    }
    return 0;
}
