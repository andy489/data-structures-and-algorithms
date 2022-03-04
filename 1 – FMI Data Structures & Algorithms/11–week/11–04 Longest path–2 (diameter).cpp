// https://www.hackerrank.com/contests/101hack33/challenges/longest-path

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> col, temp_vis, perm_vis;
vector<vector<int>> adj;

void dfs(int s, int &cur, int &far_node, int lvl = 1) {
    temp_vis[s] = 1;

    if (lvl > cur) {
        cur = lvl;
        far_node = s;
    }

    for (int child : adj[s]) {
        if (!temp_vis[child] && col[child]) {
            dfs(child, cur, far_node, lvl + 1);
        }
    }
}

void dfs_diameter(int s, int &ans, int lvl = 1) {
    perm_vis[s] = 1;
    ans = max(ans, lvl);

    for (int child : adj[s]) {
        if (!perm_vis[child] && col[child]) {
            dfs_diameter(child, ans, lvl + 1);
        }
    }
}

int main() {
    int n;
    cin >> n;

    col.resize(n + 1);
    temp_vis.resize(n + 1);
    perm_vis.resize(n + 1);
    adj.resize(n + 1);

    for (int i = 1; i <= n; ++i) {
        cin >> col[i];
    }

    int par;
    for (int i = 1; i < n; ++i) {
        cin >> par;
        adj[i + 1].push_back(par);
        adj[par].push_back(i + 1);
    }

    int longest_path_len = 0;

    for (int i = 1; i <= n; ++i) {
        if (col[i] && !perm_vis[i]) {
            int curr = 0;
            int far_node = i;
            dfs(i, curr, far_node);

            int curr_ans = 0;
            dfs_diameter(far_node, curr_ans);
            longest_path_len = max(longest_path_len, curr_ans);
        }
    }

    cout << longest_path_len;

    return 0;
}
