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

    edges.resize(n + 1);
    d.resize(n + 1);

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;

        edges[i].x = u, edges[i].y = v;

        ++d[u];
        ++d[v];
    }

    int start = 0;
    int end = n - 2;

    for (int i = 1; i < n; ++i) {
        cout << ((d[edges[i].x] == 1 || d[edges[i].y] == 1) ? start++ : end--) << endl;
    }

    return EXIT_SUCCESS;
}