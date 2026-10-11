// https://www.hackerrank.com/contests/practice-3-sda/challenges/balloons-and-candy

#include <cstdio>
#include <utility>
#include <algorithm>

using namespace std;

typedef long long ll;

const int MAX = 1e5 + 5;

pair<ll, ll> A[MAX];

int main() {
    ll n, m;
    scanf("%lld %lld", &n, &m);

    for (int i = 0; i < n; ++i) {
        scanf("%lld", &A[i].first);
    }

    for (int i = 0; i < n; ++i) {
        scanf("%lld", &A[i].second);
    }

    ll l = 0;
    ll r = 1e18;
    ll mid;
    ll s;

    while (l < r) {
        mid = l + (r - l) / 2, s = 0;

        for (int i = 0; i < n; ++i) {
            s += max(0ll, A[i].first - mid / A[i].second);
        }

        if (s <= m) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    printf("%lld", l);

    return 0;
}
