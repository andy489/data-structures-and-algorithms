// https://codeforces.com/problemset/problem/1057/A

#include <iostream>
#include <vector>

using namespace std;

int n;

vector<int> a;

void dfs(int u = n) {
    if (!u) {
        return;
    }

    dfs(a[u]);

    cout << u << ' ';
}

int main() {
    cin >> n;
    a.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        cin >> a[i];
    }

    dfs();

    return EXIT_SUCCESS;
}