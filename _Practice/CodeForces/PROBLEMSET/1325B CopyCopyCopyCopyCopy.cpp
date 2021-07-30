// github.com/andy489

// https://codeforces.com/contest/1325/problem/B

#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    int t, n, u;
    cin >> t;

    unordered_set<int> us;

    while (t--) {
        cin >> n;
        while (n--) {
            cin >> u;
            us.insert(u);
        }
        cout << us.size() << '\n';
        us.clear();
    }
    return 0;
}
