// github.com/andy489

// https://www.hackerrank.com/contests/practice-3-sda/challenges/monster-trucks

/* 
Our graphic of the function that calculates the minimum usage of monsters
for moving the trucks in one line is QUADRATIC-like, so if we assume
that our answer is ANS, then ANS will be the minimum of that
function, i.e. in any of the bound or somewhere between them.
If ANS is the answer for mid position lined, then for some p & q
we will have mid-1=mid-2=mid-p>mid and mid+1=mid+2=mid+p>mid
So that leads us to binary search on answer. 
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;
typedef long long int ll;
#define F(i, k, n) for(int i=k;i<n;++i)
#define sz(x) ((int)x.size())

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

ll getCost(const vector<Truck> &trucks, int pos) { //for a position "pos" our answer will be "ans"
    int N = sz(trucks);
    ll ans(0);
    F(i, 0, N) {
        ans += myAbs((ll) pos - (ll) trucks[i].pos) * trucks[i].cost;
    }
    return ans;
}

ll search(const vector<Truck> &trucks, int l, int r) {    // left = left most bound; right = right most bound
    if (r - l < 3) {
        ll currMin = getCost(trucks, l);
        int i;
        for (i = l + 1; i < r + 1; ++i) {
            currMin = min(currMin, getCost(trucks, i));
        }
        return currMin;
    } else if (l < r) {
        int leftThird = l + (r - l) / 3;
        int rightThird = r - (r - l) / 3;

        ll leftCost = getCost(trucks, leftThird);
        ll rightCost = getCost(trucks, rightThird);

        if (leftCost < rightCost)
            return search(trucks, l, rightThird);
        else if (leftCost > rightCost)
            return search(trucks, leftThird, r);
        else
            return min(min(search(trucks, l, leftThird), search(trucks, leftThird, rightThird)),
                       search(trucks, rightThird, r));
    }
    return -1;
}

int main() {
    int N, pos, cost;
    cin >> N;
    if (N == 0 || N == 1) {
        cout << 0;
        return 0;
    }
    vector<Truck> trucks;
    trucks.reserve(N);

    F(i, 0, N) {
        cin >> pos >> cost;
        trucks.emplace_back(pos, cost);
    }

    int minBound(INT_MAX), maxBound(INT_MIN);

    F(i, 0, N) {
        if (trucks[i].pos > maxBound) maxBound = trucks[i].pos;
        if (trucks[i].pos < minBound) minBound = trucks[i].pos;
    }

    if (N > 1)
        return cout << search(trucks, minBound, maxBound), 0;
}
