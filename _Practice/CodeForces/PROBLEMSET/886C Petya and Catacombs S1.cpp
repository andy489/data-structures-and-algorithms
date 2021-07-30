// github.com/andy489

// https://codeforces.com/problemset/problem/886/C

#include<iostream>

int n, s[(int) (2e5) + 1] = {0}, cur = 0, t;

int main() {
    std::cin >> n;
    for (int i = 1; i <= n; ++i) {
        std::cin >> t;
        if (s[t])
            s[t] = 0;
        else ++cur;
        ++s[i];
    }
    std::cout << cur;
}
