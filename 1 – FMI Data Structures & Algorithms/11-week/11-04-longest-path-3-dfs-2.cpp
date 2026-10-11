// https://www.hackerrank.com/contests/101hack33/challenges/longest-path

#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pii;
typedef vector<int> vi;

pii dfs(int i, const vector<vi> &adj, vector<bool> &vis) {
    vis[i] = true;
    pii r(0, i);

    for (const auto &child:adj[i]) {
        if (!vis[child]) {
            pii p = dfs(child, adj, vis);
            r = max(r, make_pair(p.first + 1, p.second));
        }
    }
    return r;
}

int main() {
    int n;
    cin >> n;
    vector<int> color(n);

    for (int i = 0; i < n; ++i) {
        cin >> color[i];
    }

    vector<vi> adj(n);

    int par;
    for (int i = 1; i < n; ++i) {
        cin >> par;
        --par;
        adj[par].push_back(i);
        adj[i].push_back(par);
    }
    vector<bool> vis(n), tmp(n);

    for (int i = 0; i < n; ++i) {
        tmp[i] = vis[i] = color[i] == 0;
    }

    int longest_path = 0;
    for (int i = 0; i < n; ++i) {
        if (!vis[i]) {
            pii p = dfs(i, adj, tmp);
            pii q = dfs(p.second, adj, vis);
            longest_path = max(longest_path, q.first + 1);
        }
    }
    cout << longest_path;

    return 0;
}
