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

    ll q, x;
    scanf("%lld", &q);

    while (q--) {
        scanf("%lld", &x);

        ll res = upper_bound(A.begin(), A.end(), x - 1) - A.begin() + 1;
        printf("%lld\n", res);
    }
    return 0;
}
