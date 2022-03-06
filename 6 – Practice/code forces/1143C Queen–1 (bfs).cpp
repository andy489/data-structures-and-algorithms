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
    bool to_del = true;

    while (!q.empty()) {
        curr = q.front();
        q.pop();

        if (curr > 0) {
            if (adj[curr].empty() && c[curr] == 0) {
                to_del = false;
            } else {
                for (int child:adj[curr]) {
                    q.push(child);

                    if (c[child] == 0) {
                        to_del = false;
                    }
                }

                q.push(-1);
            }
            if (to_del && c[curr]) {
                d.insert(curr);
            } else {
                to_del = true;
            }
        }
    }
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);
    c.resize(n + 1);

    int p;
    int root;
    for (int i = 1; i <= n; ++i) {
        cin >> p >> c[i];

        if (p > 0) {
            adj[p].push_back(i);
        } else {
            root = i;
        }
    }

    bfs(root);

    if (d.empty()) {
        cout << -1;

        return 0;
    } else {
        for (int x:d) {
            cout << x << ' ';
        }
    }

    return 0;
}