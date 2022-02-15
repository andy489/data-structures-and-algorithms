// https://www.spoj.com/problems/SUBMERGE/
// https://cp-algorithms.com/graph/cutpoints.html

#include <cstdio>
#include <vector>
#include <list>
#include <set>

using namespace std;

int n;
vector<list<int>> adj;
vector<bool> visited;
vector<int> tin, low, result;
set<int> articulation_points;

int timer;

void tarjan(int u = 1, int par = -1) {
    visited[u] = true;
    tin[u] = low[u] = timer++;

    int children = 0;
    for (int child : adj[u]) {
        if (child == par) {
            continue;
        }

        if (visited[child]) {
            low[u] = min(low[u], tin[child]);
        } else {
            tarjan(child, u);
            low[u] = min(low[u], low[child]);

            if (low[child] >= tin[u] && par != -1) {
                articulation_points.insert(u);
            }

            ++children;
        }
    }

    if (par == -1 && children > 1) {
        articulation_points.insert(u);
    }
}

void init(int m) {
    adj.assign(n + 1, list<int>());
    visited.assign(n + 1, false);
    tin.assign(n + 1, 0);
    low.assign(n + 1, 0);

    int u, v;
    while (m--) {
        scanf("%d %d", &u, &v);
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
}

int main() {
    int m;

    scanf("%d %d", &n, &m);
    while (m + n != 0) {
        init(m);

        tarjan();

        result.push_back(articulation_points.size());
        articulation_points.clear();

        scanf("%d %d", &n, &m);
    }

    for (int articulation_points_count :result) {
        printf("%d\n", articulation_points_count);
    }

    return 0;
}

/*
3 3
1 2
2 3
1 3
6 8
1 3
6 1
6 3
4 1
6 4
5 2
3 2
3 5
0 0
result:
0
1

6 7
1 6
1 2
1 5
5 2
1 3
3 4
4 1
0 0
result:
1
*/
