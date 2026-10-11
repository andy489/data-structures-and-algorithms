// https://www.hackerrank.com/contests/practice-3-sda/challenges/balloons-and-candy

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
typedef long long ll;

struct Day {
    ll balloon, bonbon, to_min;

    explicit Day(ll balloon = 0, ll bonbon = 0) : balloon(balloon), bonbon(bonbon) {
        to_min = balloon * bonbon;
    };
};

bool validate(const vector<Day> &D, ll mid, ll m, ll n) {
    for (int i = 0; i < n; ++i) {
        if (D[i].to_min > mid) {
            m -= ceil((D[i].to_min - mid + D[i].bonbon - 1) / D[i].bonbon);
            
            if (m < 0) {
                return false;
            }
        }
    }
    return true;
}

ll search(const vector<Day> &D, ll l, ll r, ll m, ll n) {
    while (l <= r) {
        ll mid = l + (r - l) / 2;
        
        if (validate(D, mid, m, n)) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }

    return l;
}

int main() {
    ll n, m;
    cin >> n >> m;

    vector<int> A(n), B(n);

    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }

    for (int i = 0; i < n; ++i) {
        cin >> B[i];
    }

    vector<Day> D;
    D.reserve(n);

    ll min_bound = 0;
    ll max_bound = 0;

    for (int i = 0; i < n; ++i) {
        D.emplace_back(A[i], B[i]);

        if (D[i].to_min > max_bound) {
            max_bound = D[i].to_min;
        }
    }

    cout << search(D, min_bound, max_bound, m, n);

    return 0;
}
