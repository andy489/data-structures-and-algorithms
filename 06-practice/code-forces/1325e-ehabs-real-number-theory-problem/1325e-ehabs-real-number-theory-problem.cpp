// https://codeforces.com/problemset/problem/1325/E

#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <tuple>

using namespace std;

#define ios ios::sync_with_stdio(false); cin.tie(nullptr)

const int INF = 1e9;

vector<list<int>> adj;
int max_edge = -1;

int bfs(int u, int par = -1) {
    vector<int> dist(max_edge + 1, INF); // distances to start node
    dist[u] = 0;

    queue<pair<int, int>> q;
    q.push({u, par});

    while (!q.empty()) {
        int v, fa; // v = vertex/node, fa = father/parent
        tie(v, fa) = q.front();
        q.pop();

        for (int child:adj[v]) {
            if (child == fa) {
                continue;
            }

            if (dist[child] == INF) {
                q.push({child, v});
                dist[child] = dist[v] + 1;
            } else { // we have already visited that node, so there is a cycle
                return dist[child] + dist[v] + 1;
            }
        }
    }

    return INF;
}

void normalize(int &x) {
    for (int i = 2; i * i <= x; ++i) {
        while (x % (i * i) == 0) {
            x /= (i * i);
        }
    }
}

int main() {
    ios;
    int n;
    cin >> n;

    vector<int> edges(n); // every element is like an edge (see explanation file)

    for (int &e: edges) {
        cin >> e;

        normalize(e);

        if (e == 1) {
            cout << 1;
            return 0;
        }

        if (e > max_edge) {
            max_edge = e; // finding max a_i after normalization
        }
    }

    adj.resize(max_edge + 1);

    for (auto &x: edges) {
        int fac1 = 1;
        int fac2 = x;

        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                fac1 = i;
                fac2 = x / i;

                break;
            }
        }

        adj[fac1].push_back(fac2);
        adj[fac2].push_back(fac1);
    }

    int ans = INF;

    for (int i = 1; i * i <= max_edge; ++i) {
        if (!adj[i].empty()) { // we know that every vertex is a prime number or 1
            ans = min(ans, bfs(i));
        }
    }

    cout << (ans == INF ? -1 : ans);

    return EXIT_SUCCESS;
}
