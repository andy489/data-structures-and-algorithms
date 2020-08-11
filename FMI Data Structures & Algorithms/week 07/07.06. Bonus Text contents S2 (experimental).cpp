// github.com/andy489

// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <experimental/string_view>
#include <string>
#include <iostream>
#include <unordered_map>
#include <iomanip>

using namespace std;

auto solve(const string &str, int k) {
    unordered_map<experimental::string_view, int> m;
    int Max = 0;
    experimental::string_view res;
    size_t i(0), sz(str.size());
    for (; i < sz - k + 1; ++i) {
        experimental::string_view sv(str.c_str() + i, k);
        int t = ++m[sv];
        if (t >= Max) {
            Max = t;
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
    return cout << solve(str, k), 0;
}
