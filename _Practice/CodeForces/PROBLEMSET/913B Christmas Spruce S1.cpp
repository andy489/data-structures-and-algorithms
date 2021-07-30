// github.com/andy489

// https://codeforces.com/problemset/problem/913/B

#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> adj;

bool isLeaf(int k) {
    return adj[k].empty();
}

bool isSpruce(int k) {
    int leafCount(0);
    for (int i = 0; i < adj[k].size(); ++i) {
        if (isLeaf(adj[k][i])) {
            ++leafCount;
            if (leafCount == 3)
                return true;
        }
    }
    return false;
}

int main() {
    int n, p;
    cin >> n;

    adj.assign(n + 1, vector<int>());

    for (int i = 2; i <= n; ++i) {
        cin >> p;
        adj[p].push_back(i);
    }

    for (int i = 1; i <= n; ++i) {
        if (!isLeaf(i) && !isSpruce(i)) {
            cout << "No\n";
            return 0;
        }
    }
    cout << "Yes\n";
    return 0;
}
