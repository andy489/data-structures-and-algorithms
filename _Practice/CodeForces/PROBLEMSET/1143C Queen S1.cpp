// github.com/andy489

// https://codeforces.com/problemset/problem/1143/C

#include <iostream>
#include <vector>
#include <list>
#include <set>
#include <queue>

using namespace std;

vector<list<int>> adj;
vector<int> c;
set<int> d;

void bfs(int u) {
    queue<int> q;
    q.push(u);
    q.push(-1);
    int curr;
    bool toDel = true;
    while (!q.empty()) {
        curr = q.front();
        q.pop();
        if (curr > 0) {
            if (adj[curr].empty() && c[curr] == 0) {
                toDel = false;
            } else {
                for (auto x:adj[curr]) {
                    q.push(x);
                    if (c[x] == 0)
                        toDel = false;
                }
                q.push(-1);
            }
            if (toDel && c[curr])
                d.insert(curr);
            else
                toDel = true;
        }
    }
}

int main() {
    int n, i(1), p, root;
    cin >> n;

    adj.assign(n + 1, list<int>());
    c.resize(n + 1);

    for (; i <= n; ++i) {
        cin >> p >> c[i];
        if (p > 0)
            adj[p].push_back(i);
        else
            root = i;
    }

    bfs(root);
    if (d.empty())
        return cout << -1, 0;
    else {
        for (auto x:d)
            cout << x << ' ';
    }
    return 0;
}
