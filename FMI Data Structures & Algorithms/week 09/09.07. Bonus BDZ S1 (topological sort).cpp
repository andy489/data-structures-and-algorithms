// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/bdz

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define MOD int(1e9 + 7)
typedef unsigned long long ll;

int n, m, i, j, src, dest;

vector<vector<int>> adj;
vector<int> lonely;

void add(int a, int b) {
    adj[a].push_back(b);
    lonely[b]++;
}

vector<int> topSort() {
    queue<int> Q;
    for (i = 0; i < n; ++i)
        if (!lonely[i])
            Q.push(i);
    vector<int> top;
    while (!Q.empty()) {
        int u = Q.front();
        Q.pop();

        top.push_back(u);

        for (i = 0; i < (int) adj[u].size(); ++i) {
            --lonely[adj[u][i]];
            if (!lonely[adj[u][i]])
                Q.push(adj[u][i]);
        }
    }
    return top;
}

int routes() {
    vector<int> tS = topSort();

    vector<ll> cntRoutes(n);

    cntRoutes[dest] = 1;

    for (i = (int) tS.size() - 1; i >= 0; --i) {
        for (j = 0; j < (int) adj[tS[i]].size(); ++j) {
            cntRoutes[tS[i]] += cntRoutes[adj[tS[i]][j]];
            cntRoutes[tS[i]] = cntRoutes[tS[i]] % MOD;
        }
    }

    return cntRoutes[src];
}

int main() {
    cin >> n >> m;

    adj.resize(n);
    lonely.resize(n);

    int a, b;
    for (i = 0; i < m; ++i) {
        cin >> a >> b;
        --a, --b;
        add(a, b);
    }

    cin >> src >> dest;
    --src, --dest;

    return cout << routes(), 0;
}
