// https://codeforces.com/problemset/problem/115/A

#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> immediate_manager;

    int n;
    cin >> n;

    immediate_manager.resize(n + 1);

    for (int i = 1; i <= n; ++i) {
        cin >> immediate_manager[i];
    }

    int min_groups = 0;
    for (int i = 1; i <= n; ++i) {
        int depth = 0;
        int curr = immediate_manager[i];

        while (curr != -1) {
            ++depth;
            curr = immediate_manager[curr];
        }

        min_groups = (depth > min_groups ? depth : min_groups);
    }

    cout << ++min_groups;
}