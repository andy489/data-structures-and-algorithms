// https://codeforces.com/problemset/problem/886/C

#include <iostream>
#include <set>

using namespace std;

int main() {
    int n, x;
    cin >> n;

    set<int> s;

    for (int i = 0; i < n; ++i) {
        cin >> x;
        s.insert(x);
    }

    cout << n - s.size() + 1;

    return 0;
}