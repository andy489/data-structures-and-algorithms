//github.com/andy489

// https://codeforces.com/problemset/problem/1057/A

#include <iostream>
#include <vector>
#include <list>
 
using namespace std;
 
int n;
bool flag = false;
 
vector<list<int>> adj;
list<int> path;
 
void dfs(int u) {
    path.push_back(u);
    if (u == n - 1) {
        flag = true;
        while (!path.empty()) {
            cout << path.front() << ' ';
            path.pop_front();
        }
        return;
    }
    for (auto x: adj[u]) {
        dfs(x);
        if (flag) return;
        path.pop_back();
    }
 
}
 
int main() {
    int p;
    cin >> n;
    ++n;
    adj.assign(n, list<int>());
    for (int i = 2; i < n; ++i) {
        cin >> p;
        adj[p].push_back(i);
    }
 
    dfs(1);
 
    return 0;
}
