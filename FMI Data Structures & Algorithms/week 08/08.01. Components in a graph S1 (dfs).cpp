// github.com/andy489

// https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

const int mxN = 30005;

vector<list<int>> adj(mxN, list<int>());
vector<bool> vis(mxN, false);

int dfs(int u) {
    vis[u] = true;
    int v = 1;
    for (const auto &child: adj[u])
        if (!vis[child])
            v += dfs(child);
    return v;
}

int main() {
    int n, a, b, mini(mxN), maxi(-1), u(1);
    cin >> n;

    vector<int> vertices;
    vertices.reserve(mxN / 2 + 5);

    while (n--) {
        cin >> a >> b;
        vertices.push_back(a);
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (const int &u:vertices) {
        if (!vis[u]) {
            int cnt = dfs(u);
            mini = min(mini, cnt);
            maxi = max(maxi, cnt);
        }
    }
    return cout << mini << ' ' << maxi, 0;
}
