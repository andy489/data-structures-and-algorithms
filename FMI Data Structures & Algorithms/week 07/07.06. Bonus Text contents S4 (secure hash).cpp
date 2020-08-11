// github.com/andy489

// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <cstdio>
#include <vector>
#include <iostream>
#include<unordered_map>

typedef long long ll;

ll MOD = 1000000007;
ll MOD2 = 1000000207;

using namespace std;

int main() {
    int n, k, i(0), j;
    scanf("%d%d", &n, &k);
    char h[n];
    scanf(" %[^\n]", h);
    unordered_map<ll, ll> M1, M2;
    ll p1(1), p2(1);
    for (; i < k - 1; ++i)
        p1 = (67 * p1) % MOD, p2 = (67 * p2) % MOD2;
    ll h1(0), h2(0);
    for (i = 0; i < k; ++i)
        h1 = (67 * h1 + h[i]) % MOD, h2 = (67 * h2 + h[i]) % MOD2;
    M1[h1] = 1, M2[h2] = 1;
    ll cur_best(0), a(-1), h3, h4;
    for (j = 1; j <= n - k; ++j) {
        h3 = h1, h4 = h2;
        for (i = j; i <= n - k; ++i) {
            h3 = (((h3 - p1 * h[i - 1]) * 67) + h[i + k - 1]) % MOD;
            h4 = (((h4 - p2 * h[i - 1]) * 67) + h[i + k - 1]) % MOD2;
            ++M1[h3], ++M2[h4];
        }
        if (cur_best <= M1[h1] && M1[h1] == M2[h2]) {
            cur_best = M1[h1];
            a = j - 1;
        }
        h1 = (((h1 - p1 * h[j - 1]) * 67) + h[j + k - 1]) % MOD;
        h2 = (((h2 - p2 * h[j - 1]) * 67) + h[j + k - 1]) % MOD2;
        while (M1.count(h1) != 0) {
            if (M1[h1] == cur_best)
                a = j;
            ++j;
            h1 = (((h1 - p1 * h[j - 1]) * 67) + h[j + k - 1]) % MOD;
            h2 = (((h2 - p1 * h[j - 1]) * 67) + h[j + k - 1]) % MOD2;
        }
    }
    for (i = 0; i < k; ++i)
        printf("%c", h[i + a]);
    return 0;
}
