// https://codeforces.com/problemset/problem/755/C

#include<iostream>
#include <set>

using namespace std;

set<int> s;

int main() {
    int n;
    cin >> n;

    int u;
    int total = 0;
    
    for (int i = 1; i <= n; ++i) {
        cin >> u;
        
        if (u == i) {
            ++total;
        } else {
            s.insert(u);
        }
    }

    cout << total + s.size() / 2;
}
