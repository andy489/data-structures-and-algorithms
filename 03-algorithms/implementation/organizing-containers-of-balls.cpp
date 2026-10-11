// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int q;
    cin >> q;

    int n;
    while (q--) {
        cin >> n;

        vector<int> a(n);
        vector<int> b(n);

        int x;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cin >> x;
                a[i] += x; //count of balls in each container
                b[j] += x; //count of balls in each type
            }
        }

        sort(a.begin(), a.end());
        sort(b.begin(), b.end());

        cout << (a == b ? "Possible" : "Impossible") << endl;
    }
}
