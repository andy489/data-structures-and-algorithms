// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/tunnel-maps

#include <cstdio>
#include <vector>
#include <algorithm>
#include <climits>
#include <queue>

using namespace std;

#define mxN 100000
#define s(x) scanf("%d",&x)
#define fup(x, y) for(int x=0;x<y;++x)

struct Node {
    int t, w, x, y;

    Node(int x, int y, int w, int t) : x(x), y(y), w(w), t(t) {}
};

int n, m, t, maxWeight;
vector<int> dist;
vector<bool> visited;
vector<vector<Node>> adj;

bool validate(int w) {
    fup(i, n) {
        visited[i] = false;
        dist[i] = INT_MAX;
    }

    queue<int> Q;
    int curr;

    dist[0] = 0;
    Q.push(0);

    while (!Q.empty()) {
        curr = Q.front();
        Q.pop();
        visited[curr] = true;

        fup(i, (int) adj[curr].size()) {
            if (adj[curr][i].w <= w) {
                int to(adj[curr][i].y), len(adj[curr][i].t);

                if (dist[curr] + len < dist[to]) {
                    Q.push(to);
                    dist[to] = dist[curr] + len;
                }
            }
        }
    }
    return t >= dist[n - 1];
}

int binSearchOnAns(int l, int r) {
    int ans = -1;
    while (l <= r) {
        int m = l + (r - l) / 2;

        if (validate(m)) {
            if (ans == -1)
                ans = m;
            ans = min(ans, m);
            r = m - 1;
        } else
            l = m + 1;
    }
    return ans;
}

int main() {
    dist.assign(mxN, 0);
    visited.assign(mxN, false);
    adj.resize(mxN + 1);
    s(n), s(m), s(t);

    int a, b, c, d;
    fup(i, m) {
        s(a), s(b), s(c), s(d);
        maxWeight = max(maxWeight, c);
        --a, --b;
        adj[a].emplace_back(a, b, c, d);
    }
    return printf("%d", binSearchOnAns(0, maxWeight)), 0;
}
