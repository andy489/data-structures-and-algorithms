// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/tunnel-maps

#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

const int MXN = 1e5 + 5;
#define s3(a, b, c) scanf("%d%d%d",&a,&b,&c)
#define s4(a, b, c, d) scanf("%d%d%d%d",&a,&b,&c,&d)
#define eb emplace_back

struct Node {
    int x, w, t;

    Node(int x, int w, int t) : x(x), w(w), t(t) {}
};

int dist[MXN], n, m, t, maxWeight;;
bool visited[MXN];
vector<Node> adj[MXN];

bool validate(int w) {
    fill(dist, dist + MXN, 1e9);

    queue<int> Q;
    int curr;

    dist[0] = 0;
    Q.push(0);

    while (!Q.empty()) {
        curr = Q.front();
        Q.pop();
        visited[curr] = true;

        for (const Node &child: adj[curr]) {
            if (child.w <= w) {
                int to(child.x), len(child.t);

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
        int m = (l + r) >> 1;

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
    s3(n, m, t);

    int a, b, c, d;
    while (m--) {
        s4(a, b, c, d);
        maxWeight = max(maxWeight, c);
        --a, --b;
        adj[a].eb(b, c, d);
    }
    return printf("%d", binSearchOnAns(0, maxWeight)), 0;
}
