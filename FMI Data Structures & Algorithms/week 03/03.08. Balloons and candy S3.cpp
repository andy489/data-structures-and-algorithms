// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/balloons-and-candy

#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

typedef long long ll;
using namespace std;

struct Day {
    long long a, b;

    auto operator()() const {
        return a * b;
    }

    auto balloonsNeededIfMaxCandy(long long candies) const {
        return max(0ll, a - candies / b);
    }
};

auto inp(int n) {
    vector<Day> v;
    v.reserve(n);
    int i(0);
    for (; i < n; ++i) {
        ll a;
        cin >> a;
        v.push_back(Day{a});
    }
    for (i = 0; i < n; ++i) {
        ll b;
        cin >> b;
        v[i].b = b;
    }
    return v;
}

ll balloonsNeeded(const vector<Day> &v, ll candies) {
    ll res = 0;
    for (auto &&d: v)
        res += d.balloonsNeededIfMaxCandy(candies);
    return res;
}

long long solve(const vector<Day> &v, ll m) {
    ll l = 0, r = numeric_limits<ll>::max(), ans = r;
    do {
        ll middle = (l + r) / 2;
        if (balloonsNeeded(v, middle) <= m)
            ans = middle, r = middle - 1;
        else
            l = middle + 1;
    } while (l <= r);
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    ll n, m;
    cin >> n >> m;
    auto v = inp(n);

    return cout << solve(v, m), 0;
}
