// https://www.hackerrank.com/contests/practice-7-sda/challenges/autocomplete-19-1

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

auto input(int n) {
    vector<string> arr;
    
    while (n--) {
        string t;
        cin >> t;
        
        arr.push_back(move(t));
    }
    
    return arr;
}

int query(const vector<string> &v, string &s) {
    auto it = lower_bound(v.begin(), v.end(), s);
    ++s.back();
    return lower_bound(v.begin(), v.end(), s) - it;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    auto v = input(n);
    
    sort(v.begin(), v.end());
    
    string s;
    
    while (q--) {
        cin >> s;
        cout << query(v, s) << '\n';
    }
}
