// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <experimental/string_view>
#include <iostream>
#include <unordered_map>

using namespace std;

auto solve(const string &str, int k) {
    unordered_map<experimental::string_view, int> m;
    int max = 0;
    
    experimental::string_view res;
    const int SIZE = str.size();
    
    for (int i =0; i < SIZE - k + 1; ++i) {
        experimental::string_view sv(str.c_str() + i, k);
        int t = ++m[sv];
        
        if (t >= max) {
            max = t;
            res = sv;
        }
    }
    
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int k;
    string str;
    cin >> k >> k >> ws;
    
    getline(cin, str);

    cout << solve(str, k);
    
    return 0;
}