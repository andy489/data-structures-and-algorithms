// github.com/andy489

#include <cstdio>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

const int mxN = 1e5 + 5;

#define eb emplace_back
#define s3(a, b, c) scanf("%d%d%d",&a,&b,&c)
#define s4(a, b, c, d) scanf("%d%d%d%d",&a,&b,&c,&d)

typedef tuple<int, int, int> ti3;

int n, m, rec, eqClass, dist[mxN];
bool vis[mxN];
vector<ti3> adj[mxN];

bool valid(int eq) {
    fill(dist, dist + mxN, 1e9), dist[1] = 0;
    queue<int> q;
    q.push(1);
    int curr;

    while (!q.empty()) {
        curr = q.front(), q.pop(), vis[curr] = true;
        int v, c, t; /// c = curr eq class
        for (const auto &child: adj[curr]) {
            tie(v, c, t) = child;
            if (c <= eq && dist[curr] + t < dist[v])
                q.push(v), dist[v] = dist[curr] + t;
        }
    }
    return rec >= dist[n];
}

int bsa(int l = 0, int r = eqClass, int ans = -1) {
    while (l <= r) {
        int m = (l + r) >> 1;
        if (valid(m)) {
            if (ans == -1) ans = m;
            ans = min(ans, m), r = m - 1;
        } else l = m + 1;
    }
    return ans;
}

void init() {
    s3(n, m, rec);
    int u, v, c, t;
    while (m--) {
        s4(u, v, c, t);
        eqClass = max(eqClass, c);
        adj[u].eb(v, c, t);
    }
}

int main() {
    return init(), printf("%d", bsa()), 0;
}
