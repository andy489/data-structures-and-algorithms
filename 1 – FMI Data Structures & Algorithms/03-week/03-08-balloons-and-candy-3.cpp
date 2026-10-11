// https://www.hackerrank.com/contests/practice-3-sda/challenges/balloons-and-candy

#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

typedef long long ll;
using namespace std;

struct Day {
    ll a, b;

    [[nodiscard]] auto balloons_needed_if_max_candy(ll candies) const {
        return max(0ll, a - candies / b);
    }
};

auto input(int n) {
    vector<Day> arr;
    arr.reserve(n);

    for (int i = 0; i < n; ++i) {
        ll a;
        cin >> a;
        arr.push_back(Day{a});
    }

    for (int i = 0; i < n; ++i) {
        ll b;
        cin >> b;
        arr[i].b = b;
    }

    return arr;
}

ll balloonsNeeded(const vector<Day> &v, ll candies) {
    ll res = 0;

    for (auto &&d: v) {
        res += d.balloons_needed_if_max_candy(candies);
    }

    return res;
}

long long solve(const vector<Day> &v, ll m) {
    ll l = 0;
    ll r = numeric_limits<ll>::max();
    ll ans = r;

    do {
        ll middle = (l + r) / 2;
        if (balloonsNeeded(v, middle) <= m) {
            ans = middle, r = middle - 1;
        }
        else {
            l = middle + 1;
        }
    } while (l <= r);

    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    ll n, m;
    cin >> n >> m;

    auto v = input(n);

    cout << solve(v, m);

    return 0;
}
