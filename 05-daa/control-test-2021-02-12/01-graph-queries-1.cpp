// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/1-290

#include <cstdio>
#include <vector>

using namespace std;

typedef pair<int, int> pii;

#define eb emplace_back
#define f first
#define s second

const int MXN = 555 + 5, MOD = 1e9 + 21;

int N, M, Q, dist[MXN][MXN], dp[MXN][MXN];
vector<pii> adj[MXN];
int u, v, w;

void init() {
    scanf("%d%d", &N, &M);
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            if (i != j) {
                dist[i][j] = 1e9;
            }
        }
    }

    while (M--) {
        scanf("%d%d%d", &u, &v, &w);

        adj[u].eb(w, v), adj[v].eb(w, u);
        dist[u][v] = w, dist[v][u] = w;
    }
}

void pre_process() {
    for (int k = 1; k <= N; ++k) {
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
}

int cnt_shortest_paths(int u, int v) {
    if (u == v) {
        return 1;
    }
    
    if (dp[u][v]) {
        return dp[u][v];
    }
    
    for (const auto &child : adj[u]) {
        if (dist[u][v] == dist[child.s][v] + child.f) {
            int temp = cnt_shortest_paths(child.s, v) % MOD;
            
            dp[u][v] = (dp[u][v] + temp) % MOD;
        }
    }
    
    return dp[u][v];
}

void queries() {
    scanf("%d", &Q);
    
    while (Q--) {
        scanf("%d%d", &u, &v);
        printf("%d ", cnt_shortest_paths(u, v));
    }
}

int main() {
    init();

    pre_process();
    
    queries();
    
    return  0;
}
