// github.com/andy489

// https://www.hackerrank.com/contests/practice-4-sda/challenges/truck-ordering/

#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

void inp(vector<int> &a, int n) {
    for (int i = 0; i < n; ++i) cin >> a[i];
}

bool solve(const vector<int> &a, int n) {
    stack<int> s;
    auto p = a.begin();
    int c = 0;
    for (;;) {
        if (p == a.end()) return true;
        if (!s.empty() && s.top() == *p) ++p, s.pop();
        else if (c >= n) return false;
        else s.push(++c);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        inp(a, n);
        reverse(a.begin(), a.end());
        cout << (solve(a, n) ? "yes" : "no") << endl;
    }
}
