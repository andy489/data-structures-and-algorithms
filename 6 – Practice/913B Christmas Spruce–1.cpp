// https://codeforces.com/problemset/problem/913/B

#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> adj;

const int SPRUCE_CNT = 3;

bool is_leaf(int u) {
    return adj[u].empty();
}

bool is_spurce(int u) {
    int leaf_cnt = 0;

    for (int child: adj[u]) {
        if (is_leaf(child)) {
            ++leaf_cnt;

            if (leaf_cnt == SPRUCE_CNT) {
                return true;
            }
        }
    }

    return false;
}

int main() {
    int n;
    cin >> n;

    adj.resize(n + 1);

    int p;
    for (int i = 2; i <= n; ++i) {
        cin >> p;
        adj[p].push_back(i);
    }

    bool spurce_tree = true;

    for (int i = 1; i <= n; ++i) {
        if (!is_leaf(i) && !is_spurce(i)) {
            spurce_tree = false;
            break;
        }
    }

    cout << (spurce_tree ? "Yes" : "No");

    return 0;
}
