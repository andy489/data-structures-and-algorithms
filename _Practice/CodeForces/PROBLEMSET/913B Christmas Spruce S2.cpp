// github.com/andy489

// https://codeforces.com/problemset/problem/913/B

#include <iostream>

using namespace std;

int i = 1, n, c[1002], d[1002], p[1002];

int main() {
    for (cin >> n; i++ < n;) {
        cin >> p[i];
        c[p[i]]++;
    }
    for (i = 0; i++ < n;)
        if (!c[i]) 
            d[p[i]]++;
    for (i = 0; i++ < n;)
        if (c[i] && d[i] < 3)
            return cout << "No", 0;
    cout << "Yes";
}
