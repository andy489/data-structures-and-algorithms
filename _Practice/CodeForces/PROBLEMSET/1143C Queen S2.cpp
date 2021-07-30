// github.com/andy489

// https://codeforces.com/problemset/problem/1143/C

#include <iostream>

#define mxN (int)1e5

using namespace std;
int p[mxN], c[mxN], s[mxN];

int main() {
    int n, i, flag(0);
    cin >> n;
    for (i = 1; i <= n; ++i)
        cin >> p[i] >> c[i], s[i] = c[i];
    for (i = 1; i <= n; i++)
        if (p[i] > 0)
            s[p[i]] &= c[i];
    for (i = 1; i <= n; i++)
        if (s[i])
            cout << i << ' ', flag = 1;
    if (!flag)
        cout << -1;
}
