// https://www.hackerrank.com/contests/practice-3-sda/challenges/monster-trucks

#include <iostream>

using namespace std;
typedef long long ll;

ll pow_needed(const int *trucks, const int *powers, int n, ll distance) {
    ll power = 0;

    for (int i = 0; i < n; ++i) {
        power += (abs(distance - trucks[i]) * powers[i]);
    }

    return power;
}

ll bin_search(const int *trucks, const int *powers, int n, int start, int end) {
    if (end - start < 3) {
        ll curr_min = pow_needed(trucks, powers, n, start);

        for (int i = start + 1; i < end + 1; ++i) {
            curr_min = min(curr_min, pow_needed(trucks, powers, n, i));
        }

        return curr_min;
    }

    if (start >= end) {
        return pow_needed(trucks, powers, n, end);
    }

    int mid = start + (end - start) / 2;

    if (pow_needed(trucks, powers, n, mid) < pow_needed(trucks, powers, n, mid + 1)) {
        return bin_search(trucks, powers, n, start, mid);
    } else if (pow_needed(trucks, powers, n, mid) > pow_needed(trucks, powers, n, mid + 1)) {
        return bin_search(trucks, powers, n, mid + 1, end);
    } else {
        return pow_needed(trucks, powers, n, mid);
    }
}

void truck() {
    int n;
    cin >> n;

    if (n <= 1) {
        cout << 0;
        return;
    }

    int *k = new int[n];
    int *m = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> k[i] >> m[i];
    }

    int low, hi;

    for (int i = 0; i < n; ++i) {
        if (low > k[i]) {
            low = k[i];
        }
        if (hi < k[i]) {
            hi = k[i];
        }
    }

    cout << bin_search(k, m, n, low, hi);
}

int main() {
    truck();
    return 0;
}
