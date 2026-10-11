// https://www.hackerrank.com/contests/101hack33/challenges/longest-path

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> color;
vector<vector<int>> adj;

int longest_path_len(0);

int dfs(int s = 0) {
    int a[3]{0, 0, 0};

    for (int child : adj[s]) {
        a[0] = dfs(child);
        sort(a, a + 3);
    }

    if (color[s]) {
        longest_path_len = max(longest_path_len, 1 + a[1] + a[2]);
        return 1 + a[2];
    } else {
        return 0;
    }
}

int main() {
    int n;
    cin >> n;

    color.resize(n);
    adj.resize(n);

    for (int i = 0; i < n; ++i) {
        cin >> color[i];
    }

    int par;
    for (int i = 1; i < n; ++i) {
        cin >> par;
        --par;
        adj[par].push_back(i);
    }

    dfs();

    cout << longest_path_len;

    return 0;
}
