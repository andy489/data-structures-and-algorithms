// https://codeforces.com/problemset/problem/913/B

#include <iostream>
#include <vector>

using namespace std;

int main() {
    const int SPURCE_CNT = 3;

    int n;
    cin >> n;

    vector<int> neighbours(n + 1);
    vector<int> children(n + 1);
    vector<int> p(n + 1);

    for (int i = 2; i <= n; ++i) {
        cin >> p[i];

        ++neighbours[p[i]];
    }

    for (int i = 1; i <= n; ++i) {
        if (!neighbours[i]) {
            ++children[p[i]];
        }
    }

    bool spurce_tree = true;

    for (int i = 0; i++ < n;) {
        if (neighbours[i] && children[i] < SPURCE_CNT) {
            spurce_tree = false;
            break;
        }
    }

    cout << (spurce_tree ? "Yes" : "No");

    return EXIT_SUCCESS;
}