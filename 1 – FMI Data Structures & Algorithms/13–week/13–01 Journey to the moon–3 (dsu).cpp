// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

#include <iostream>
#include <vector>

using namespace std;

vector<int> parent, sz;

int find_set(int x) {
    return parent[x] = parent[x] == x ? x : find_set(parent[x]);
}

int main() {
    int n, m;
    cin >> n >> m;

    parent.resize(n);
    sz.resize(n);

    for (int i = 0; i < n; ++i) {
        parent[i] = i;
    }

    int u, v;
    while (m--) {
        cin >> u >> v;
        int r1 = find_set(u);
        int r2 = find_set(v);

        parent[r1] = r2;
    }

    for (int i = 0; i < n; ++i) {
        ++sz[find_set(i)];
    }

    long long sum = (long long) n * n;

    for (int c:sz) {
        sum -= c * c;
    }
    
    cout << sum / 2;
    
    return 0;
}