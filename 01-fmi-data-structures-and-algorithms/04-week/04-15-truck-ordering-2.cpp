// https://www.hackerrank.com/contests/practice-4-sda/challenges/truck-ordering/

#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

void read_input(vector<int> &a, int n) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

bool order_trucks(const vector<int> &a, int n) {
    stack<int> s;
    auto p = a.begin();
    int c = 0;

    for (;;) {
        if (p == a.end()) {
            return true;
        }

        if (!s.empty() && s.top() == *p) ++p, s.pop();

        else if (c >= n) {
            return false;
        } else {
            s.push(++c);
        }
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
        read_input(a, n);

        reverse(a.begin(), a.end());

        cout << (order_trucks(a, n) ? "yes" : "no") << endl;
    }
}
