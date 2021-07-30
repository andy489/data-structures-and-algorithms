// github.com/andy489

// https://codeforces.com/contest/1325/problem/D

#include <iostream>

using namespace std;
typedef long long ll;

int main() {
    ll u, v;
    cin >> u >> v;
    if (((u & 1) != (v & 1)) || u > v)
        return cout << -1, 0;
    if (u == v) {
        if (!v)
            return cout << 0, 0;
        return cout << 1 << '\n' << u, 0;
    }
    ll x = (v - u) / 2;
    if (u & x)
        cout << 3 << '\n' << u << ' ' << x;
    else
        cout << 2 << '\n' << u + x;
    return cout << ' ' << x, 0;
}
