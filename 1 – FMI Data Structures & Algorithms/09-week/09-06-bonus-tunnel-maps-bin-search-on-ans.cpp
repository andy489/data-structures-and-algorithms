// https://www.hackerrank.com/contests/practice-8-sda/challenges/tunnel-maps

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 1e5 + 5;

struct Node {
    int x, w, t;

    Node(int x, int w, int t) : x(x), w(w), t(t) {}
};

int n, t;
vector<Node> adj[MAX];
int dist[MAX];

bool validate_via_dijkstra(int w) {
    fill(dist, dist + MAX, 1e9);

    queue<int> q;
    int curr;

    dist[0] = 0;
    q.push(0);

    while (!q.empty()) {
        curr = q.front();
        q.pop();

        for (const Node &child: adj[curr]) {
            if (child.w <= w) {
                int to = child.x;
                int len = child.t;

                if (dist[curr] + len < dist[to]) {
                    q.push(to);
                    dist[to] = dist[curr] + len;
                }
            }
        }
    }

    return t >= dist[n - 1];
}

int bin_search_on_ans(int l, int r) {
    int ans = -1;

    while (l <= r) {
        int m = l + (r - l) / 2;

        if (validate_via_dijkstra(m)) {
            if (ans == -1) {
                ans = m;
            }

            ans = min(ans, m);
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    return ans;
}

int main() {
    int m;
    cin >> n >> m >> t;

    int a, b, c, d, max_weight = 0;
    while (m--) {
        cin >> a >> b >> c >> d;
        max_weight = max(max_weight, c);
        adj[a - 1].emplace_back(b - 1, c, d);
    }

    cout << bin_search_on_ans(0, max_weight);

    return 0;
}
