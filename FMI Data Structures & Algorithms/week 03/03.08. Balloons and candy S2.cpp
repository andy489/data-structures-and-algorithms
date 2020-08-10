// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/balloons-and-candy

#include <cstdio>
#include <utility>
#include <algorithm>

typedef long long ll;

using namespace std;

const int mxN = 100005;

ll n, m, l, r = 1e18, mid, s;
pair<ll, ll> A[mxN];

int main() {
    scanf("%lld%lld", &n, &m);
    int i(i);
    for (; i < n; ++i)
        scanf("%lld", &A[i].first);

    for (i = 0; i < n; ++i)
        scanf("%lld", &A[i].second);

    while (l < r) {
        mid = l + (r - l) / 2, s = 0;

        for (i = 0; i < n; ++i)
            s += max(0ll, A[i].first - mid / A[i].second);

        if (s <= m)
            r = mid;
        else
            l = mid + 1;
    }
    return printf("%lld", l), 0;
}
