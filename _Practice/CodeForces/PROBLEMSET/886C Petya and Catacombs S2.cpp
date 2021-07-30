// github.com/andy489

// https://codeforces.com/problemset/problem/886/C

#include<iostream>
#include <set>

using namespace std;

set<int> s;

int main() {
    int n, x, i(0);
    cin >> n;
    for (; i < n; i++)
        cin >> x, s.insert(x);
    return cout << n - s.size() + 1, 0;
}
