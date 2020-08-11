// github.com/andy489

// https://www.hackerrank.com/contests/sda-hw-10/challenges/components-in-graph/problem

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

const int mxN = 1 << 15;

vector<list<int>> adj(mxN, list<int>());
bool vis[mxN];

int bfs(int u) {
    int cnt(0);
    queue<int> q;
    q.push(u);
    vis[u] = true;

    while (!q.empty()) {
        int v = q.front();
        q.pop();  ++cnt;
        for (const int &child:adj[v]) {
            if (!vis[child]) {
                vis[child] = true;
                q.push(child);
            }
        }
    }
    return cnt;
}

int main() {
    int n, a, b, mini(mxN), maxi(-1);
    cin >> n;

    vector<int> vertices;
    vertices.reserve(mxN / 2);

    while (n--) {
        cin >> a >> b;
        vertices.push_back(a);
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (const int &u:vertices) {
        if (!vis[u]) {
            int cnt = bfs(u);
            mini = min(mini, cnt);
            maxi = max(maxi, cnt);
        }
    }

    return cout << mini << " " << maxi, 0;
}
