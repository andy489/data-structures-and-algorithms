// github.com/andy489

// https://codeforces.com/problemset/problem/755/C

#include<iostream>
#include <set>

using namespace std;

set<int> s;

int main() {
    int n, i(1), x, t(0);
    cin >> n;
    for (; i <= n; ++i) {
        cin >> x;
        if (x == i)
            ++t;
        else
            s.insert(x);
    }
    cout << t + s.size() / 2;
}
