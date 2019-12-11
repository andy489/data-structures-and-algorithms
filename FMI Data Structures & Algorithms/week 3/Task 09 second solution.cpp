#include <cstdio>
#include <utility>
#include <algorithm>

using namespace std;

const int MAXN = 100005;

long long n, m, l, r = 1e18, mid, s;
pair<long long, long long> A[MAXN];

int main() {
    scanf("%lld%lld", &n, &m);

    for (int i = 0; i < n; i++) {
        scanf("%lld", &A[i].first);
    }

    for (int i = 0; i < n; i++) {
        scanf("%lld", &A[i].second);
    }

    while (l < r) {
        mid = l + (r - l) / 2;
        s = 0;

        for (int i = 0; i < n; i++) {
            s += max(0ll, A[i].first - mid / A[i].second);
        }

        if (s <= m) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    printf("%lld\n", l);

    return 0;
}
