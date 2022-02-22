// https://www.hackerrank.com/challenges/cpp-lower-bound/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> a(n);

    for (auto &x:a) {
        cin >> x;
    }

    int q, y;
    cin >> q;

    while (q--) {
        cin >> y;
        auto it = lower_bound(a.begin(), a.end(), y);
        
        cout << (*it == y ? "Yes " : "No ") << (it - a.begin() + 1) << endl;
    }
    
    return 0;
}
