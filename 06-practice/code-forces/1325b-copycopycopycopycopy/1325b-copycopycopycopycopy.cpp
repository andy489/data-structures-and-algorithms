// https://codeforces.com/contest/1325/problem/B

#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    int t;
    cin >> t;

    unordered_set<int> us;

    int n;
    while (t--) {
        cin >> n;

        int u;
        while (n--) {
            cin >> u;
            us.insert(u);
        }

        cout << us.size() << endl;
        us.clear();
    }

    return 0;
}