// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/shortest-tour/problem

#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <list>
#include <queue>

using namespace std;

unordered_map<int, list<int>> adj;
unordered_set<int> vis;

int bfs(int start, int end) {
    queue<int> q;
    q.push(start);
    vis.insert(start);

    int lvl(0);
    while (!q.empty()) {
        int s = q.size();
        while (s--) {
            int cur = q.front();
            vis.insert(cur);
            if (cur == end)
                return lvl;
            for (const auto &child : adj[cur])
                if (!vis.count(child))
                    q.push(child);
            q.pop();
        }
        ++lvl;
    }
    return -1;
}

int main() {
    int N, M, a, b, K;
    cin >> N >> M;

    adj.reserve(N);
    vis.reserve(N);

    while (M--) {
        cin >> a >> b;
        adj[a].push_back(b);
    }

    cin >> K;

    vector<int> path(K);

    for (a = 0; a < K; ++a)
        cin >> path[a];

    int shortest(0);

    for (a = 0; a < K - 1; ++a) {
        for (b = a + 2; b < K; ++b)
            vis.insert(path[b]);

        int dist = bfs(path[a], path[a + 1]);
        vis.clear();

        if (dist != -1)
            shortest += dist;
        else
            return cout << dist, 0;
    }
    return cout << shortest, 0;
}
