// https://www.hackerrank.com/contests/practice-8-sda/challenges/bdz

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int MOD = 1e9 + 7;

int n, src, dest;
vector<vector<int>> adj;
vector<int> in;

vector<int> top_sort_kahn() {
    queue<int> q;
    for (int i = 0; i < n; ++i) {
        if (!in[i]) {
            q.push(i);
        }
    }

    vector<int> top;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        top.push_back(u);

        const int SIZE = adj[u].size();
        for (int i = 0; i < SIZE; ++i) {
            --in[adj[u][i]];

            if (!in[adj[u][i]]) {
                q.push(adj[u][i]);
            }
        }
    }

    return top;
}

int routes() {
    vector<int> ts = top_sort_kahn();

    vector<int> cnt_routes(n);

    cnt_routes[dest] = 1;

    for (int i = (int) ts.size() - 1; i >= 0; --i) {
        const int SIZE = adj[ts[i]].size();

        for (int j = 0; j < SIZE; ++j) {
            cnt_routes[ts[i]] += cnt_routes[adj[ts[i]][j]];
            cnt_routes[ts[i]] = cnt_routes[ts[i]] % MOD;
        }
    }

    return cnt_routes[src];
}

int main() {
    int m;
    cin >> n >> m;

    adj.resize(n);
    in.resize(n);

    int a, b;
    while (m--) {
        cin >> a >> b;
        --a, --b;
        adj[a].push_back(b);
        ++in[b];
    }

    cin >> src >> dest;
    --src, --dest;

    cout << routes();

    return 0;
}
