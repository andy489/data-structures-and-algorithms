// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>col,temp_vis,perm_vis;
vector<vector<int>>adj;

void dfs(int s, int& cur,int& far_node, int lvl = 1) {
    temp_vis[s] = 1;
    if (lvl > cur) {
        cur = lvl;
        far_node = s;
    }
    for (const auto& child : adj[s]) {
        if (!temp_vis[child]&&col[child]) {
            dfs(child,cur,far_node, lvl + 1);
        }
    }
}

void dfs_diam(int s,int& ans,int lvl=1){
    perm_vis[s] = 1;
    ans = max(ans, lvl);
    for (const auto& child : adj[s]) {
        if (!perm_vis[child] && col[child]) {
            dfs_diam(child,ans, lvl + 1);
        }
    }
}

int main() {
    int n, i;
    cin >> n;
    col.resize(n + 1);
    temp_vis.resize(n + 1);
    perm_vis.resize(n + 1);    
    adj.resize(n + 1);

    for (i = 1;i <= n;++i) {
        cin >> col[i];
    }
    int a;
    for (i = 1;i < n;++i) {
        cin >> a;
        adj[i + 1].push_back(a);
        adj[a].push_back(i + 1);
    }

    int max_path(0);

    for (i = 1;i <= n;++i) {
        if (col[i] && !perm_vis[i]) {
            int cur(0),far_node(i);
            dfs(i,cur,far_node);
            int cur_ans(0);
            dfs_diam(far_node,cur_ans);
            max_path = max(max_path, cur_ans);
        }
    }
    cout << max_path;
    return 0;
}
