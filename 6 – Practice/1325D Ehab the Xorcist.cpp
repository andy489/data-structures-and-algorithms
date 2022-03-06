// https://codeforces.com/contest/1325/problem/D

#include <iostream>

using namespace std;

typedef long long ll;

int main() {
    ll u, v;
    cin >> u >> v;

    if (((u & 1) != (v & 1)) || u > v) {
        cout << -1;
        return 0;
    }

    if (u == v) {
        if (!v) {
            cout << 0;

            return 0;
        }

        cout << 1 << endl << u;

        return 0;
    }

    ll x = (v - u) / 2;

    if (u & x) {
        cout << 3 << endl << u << ' ' << x;
    } else {
        cout << 2 << endl << u + x;
    }

    cout << ' ' << x;

    return 0;
}