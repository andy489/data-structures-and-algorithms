// github.com/andy489

// https://www.hackerrank.com/contests/test6-sda/challenges/challenge-1761/problem

#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

vector<set<int>> adj;
queue<int> Q; // leaves
vector<int> mark;

int main() {
    int V, E, a, b, i(0), ans(0);

    cin >> V >> E;

    adj.assign(V + 1, set<int>());
    mark.assign(V + 1, 0);

    for (; i < E; ++i) {
        cin >> a >> b;
        adj[a].insert(b);
        adj[b].insert(a);
    }

    for (i = 1; i <= V; ++i)
        if (adj[i].size() < 2)
            Q.push(i);

    while (!Q.empty()) {
        a = Q.front();
        Q.pop();

        if (adj[a].size() < 1)
            continue;

        b = *adj[a].begin();
        adj[b].erase(a);

        if (adj[b].size() < 2)
            Q.push(b); // new leave

        if (mark[a])
            ++ans;
        else
            mark[b] ^= 1;
    }

    return cout << ans, 0;
}
