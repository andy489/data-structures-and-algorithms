// https://www.hackerrank.com/challenges/cpp-lower-bound/problem

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    int *a = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    int q, x;
    cin >> q;

    while (q--) {
        cin >> x;
        int el = *lower_bound(a, a + n, x);

        cout << (el == x ? "Yes " : "No ") << lower_bound(a, a + n, x) - a + 1 << endl;
    }

    return 0;
}
