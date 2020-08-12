// github.com/andy489

// https://www.hackerrank.com/contests/practice-9-sda/challenges/kruskalmstrsub

#include <iostream>
#include <algorithm>

using namespace std;

int p[3030];
pair<int, pair<int, int> > edge[5000000];

int find(int j) { return p[j] == j ? j : p[j] = find(p[j]); }

int main() {
    int n, m, a, b, w, i(1);
    cin >> n >> m;
    for (; i <= n; ++i)
        p[i] = i;
    for (i = 0; i < m; ++i) {
        cin >> a >> b >> w;
        edge[i] = make_pair(w, make_pair(a, b));
    }

    sort(edge, edge + m);

    int ans(0);
    for (i = 0; i < m; ++i) {
        int x = find(edge[i].second.first);
        int y = find(edge[i].second.second);
        if (x != y) {
            p[x] = y;
            ans += edge[i].first;
        }
    }
    return cout << ans, 0;
}
