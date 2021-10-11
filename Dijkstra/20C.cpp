//  http://codeforces.com/contest/20/problem/C

//  Time complexity:  O(|V|+|E|log(|V|))  = O((n+m)log(n))
//  Space:            O(|V|+|E|)          = O(n+m)

#include <cstdio>
#include <vector>
#include <list>
#include <queue>
#include <stack>

typedef long long ll;
#define pb push_back

const ll INF = 9'223'372'036'854'775'807;

using namespace std;

struct Edge {
    int v, w;

    Edge(int v, int w) : v(v), w(w) {}
};

int n;
vector<list<Edge>> adj;
vector<int> par;
vector<ll> dist;

void init() {
    int m, u, v, w;
    scanf("%d %d", &n, &m);
    adj.resize(n + 1);
    while (m--) {
        scanf("%d %d %d", &u, &v, &w);
        adj[u].pb({v, w});
        adj[v].pb({u, w});
    }
}

void dijkstra(int s = 1) {
    par.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        par[i] = i;
    }
    dist.resize(n + 1, INF);

    priority_queue<pair<ll, int>> Q;
    Q.push({0LL, s});
    dist[s] = 0;

    while (!Q.empty()) {
        int u = Q.top().second;
        if (u == n) {
            return;
        }
        Q.pop();
        if (dist[u]!=INF) {
            for (const Edge &child:adj[u]) {
                if(par[child.v] == u){
                    continue;
                }
                int v = child.v;
                int w = child.w;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    Q.push({-dist[v], v});
                    par[v] = u;
                }
            }
        }
    }
}

void printPath(){
    if (dist[n] == INF) {
        return void(printf("-1\n"));
    }
    printf("1 ");
    int t = n;
    stack<int> path;
    path.push(t);
    while (par[t] != 1) {
        t = par[t];
        path.push(t);
    }
    while (!path.empty()) {
        printf("%d ", path.top());
        path.pop();
    }
}

int main() {
    init();
    dijkstra();
    printPath();
    return 0;
}
