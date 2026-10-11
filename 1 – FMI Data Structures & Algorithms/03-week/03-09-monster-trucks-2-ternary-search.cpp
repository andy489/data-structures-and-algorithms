// https://www.hackerrank.com/contests/practice-3-sda/challenges/monster-trucks

/*
the graphic of the function that calculates the minimum usage of monsters
for moving the trucks in one line is parable, so if we assume
that our answer is RES, then RES will be the minimum of that
function, i.e. in any of the bound or somewhere between them.
If RES is the answer for mid position lined, then for some p & q
we will have mid - 1 = mid - 2 = mid - p > mid and
mid + 1 = mid + 2 = mid + p > mid. So that leads us to ternary search on answer
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long int ll;


ll myAbs(ll a) {
    return a >= 0 ? a : -a;
}

struct Truck {
    int pos, cost; // cost = number of monsters
    Truck() : pos(0), cost(0) {};

    Truck(int pos, int cost) : pos(pos), cost(cost) {};

    bool operator<(const Truck &other) const {
        return this->pos < other.pos;
    }
};

ll getCost(const vector<Truck> &trucks, int pos) { // for a position "pos" our answer will be "ans"
    int N = trucks.size();
    ll ans = 0;

    for (int i = 0; i < N; ++i) {
        ans += myAbs((ll) pos - (ll) trucks[i].pos) * trucks[i].cost;
    }

    return ans;
}

ll search(const vector<Truck> &trucks, int l, int r) {    // left = left most bound; right = right most bound
    if (r - l < 3) {
        ll currMin = getCost(trucks, l);

        for (int i = l + 1; i < r + 1; ++i) {
            currMin = min(currMin, getCost(trucks, i));
        }

        return currMin;
    } else if (l < r) {
        int leftThird = l + (r - l) / 3;
        int rightThird = r - (r - l) / 3;

        ll leftCost = getCost(trucks, leftThird);
        ll rightCost = getCost(trucks, rightThird);

        if (leftCost < rightCost) {
            return search(trucks, l, rightThird);
        } else if (leftCost > rightCost) {
            return search(trucks, leftThird, r);
        } else {
            return min(min(search(trucks, l, leftThird), search(trucks, leftThird, rightThird)),
                       search(trucks, rightThird, r));
        }
    }
    return -1;
}

int main() {
    int n, pos, cost;
    cin >> n;

    if (n == 0 || n == 1) {
        cout << 0;
        return 0;
    }

    vector<Truck> trucks;
    trucks.reserve(n);

    for (int i = 0; i < n; ++i) {
        cin >> pos >> cost;
        trucks.emplace_back(pos, cost);
    }

    int min_bound = 1e9;
    int max_bound = -1e9;

    for (int i = 0; i < n; ++i) {
        if (trucks[i].pos > max_bound) max_bound = trucks[i].pos;
        if (trucks[i].pos < min_bound) min_bound = trucks[i].pos;
    }

    if (n > 1) {
        cout << search(trucks, min_bound, max_bound);
    }

    return 0;
}
