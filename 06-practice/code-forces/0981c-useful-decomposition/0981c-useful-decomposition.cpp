// https://codeforces.com/problemset/problem/981/C

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> deg(n + 1);
    vector<int> leaves(n + 1);

    int u, v;
    for (int i = 1; i < n; ++i) {
        cin >> u >> v;
        ++deg[u];
        ++deg[v];
    }

    int top = 0;
    int root;
    int all = 0;

    for (int i = 1; i <= n; ++i) {
        if (deg[i] == 1) {
            leaves[++top] = i;
        }

        if (deg[i] > 2) {
            root = i, ++all;
        }
    }

    if (all > 1) {
        cout << "No";
        return EXIT_SUCCESS;
    }

    cout << "Yes" << endl;
    if (all == 0) {
        cout << 1 << endl << leaves[1] << ' ' << leaves[2] << endl;
    } else {
        cout << top << endl;

        for (int i = 1; i <= top; ++i) {
            cout << root << ' ' << leaves[i] << endl;
        }
    }

    return EXIT_SUCCESS;
}