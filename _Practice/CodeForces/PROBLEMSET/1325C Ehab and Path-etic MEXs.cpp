// github.com/andy489

// https://codeforces.com/problemset/problem/1325/C

#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

#define x first
#define y second

vector<pii> edges; // edge list
vector<int> d; // degree of vertices

int main() {
    int n;
    cin >> n;

    edges.assign(n + 1, pii());
    d.assign(n + 1, 0);

    int i(1), u, v;
    for (; i < n; ++i) {
        cin >> u >> v;
        edges[i].x = u, edges[i].y = v;
        ++d[u], ++d[v];
    }

    int start(0), end(n - 2);
    for (i = 1; i < n; ++i) {
        if (d[edges[i].x] == 1 || d[edges[i].y] == 1)
            cout << start++;
        else
            cout << end--;
        cout << '\n';
    }
    return 0;
}
