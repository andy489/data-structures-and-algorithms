// https://codeforces.com/problemset/problem/886/C

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> notes(n + 1);
    int curr = 0;

    int t;
    for (int i = 1; i <= n; ++i) {
        cin >> t;

        notes[t] ? notes[t] = 0 : ++curr;

        ++notes[i];
    }

    cout << curr;
}