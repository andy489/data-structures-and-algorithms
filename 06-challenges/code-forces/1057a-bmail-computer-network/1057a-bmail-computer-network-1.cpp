// https://codeforces.com/problemset/problem/1057/A

#include <iostream>
#include <vector>
#include <list>

using namespace std;

int n;
bool flag = false;

vector<list<int>> adj;
list<int> path;

void dfs(int u = 1) {
    path.push_back(u);

    if (u == n - 1) {
        flag = true;

        while (!path.empty()) {
            cout << path.front() << ' ';
            path.pop_front();
        }

        return;
    }

    for (int child: adj[u]) {
        dfs(child);
        if (flag) {
            return;
        }

        path.pop_back();
    }

}

int main() {
    cin >> n;
    ++n;

    adj.resize(n);

    int p;
    for (int i = 2; i < n; ++i) {
        cin >> p;
        adj[p].push_back(i);
    }

    dfs();

    return EXIT_SUCCESS;
}
