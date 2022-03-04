// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <cstdio>
#include <unordered_map>

typedef long long ll;

ll MOD1 = 1e12 + 39; // prime
ll MOD2 = 1e12 + 61; // prime

ll SHUFFLE = 2777; // prime

using namespace std;

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    char h[n];
    scanf(" %[^\n]", h);

    unordered_map<ll, ll> m1, m2;

    ll p1 = 1;
    ll p2 = 1;
    for (int i = 0; i < k - 1; ++i) {
        p1 = (SHUFFLE * p1) % MOD1, p2 = (SHUFFLE * p2) % MOD2;
    }

    ll h1 = 0;
    ll h2 = 0;

    for (int i = 0; i < k; ++i) {
        h1 = (SHUFFLE * h1 + h[i]) % MOD1, h2 = (SHUFFLE * h2 + h[i]) % MOD2;
    }

    m1[h1] = 1;
    m2[h2] = 1;

    ll cur_best = 0;
    ll a = -1;
    ll h3, h4;

    for (int j = 1; j <= n - k; ++j) {
        h3 = h1, h4 = h2;

        for (int i = j; i <= n - k; ++i) {
            h3 = (((h3 - p1 * h[i - 1]) * SHUFFLE) + h[i + k - 1]) % MOD1;
            h4 = (((h4 - p2 * h[i - 1]) * SHUFFLE) + h[i + k - 1]) % MOD2;
            ++m1[h3], ++m2[h4];
        }

        if (cur_best <= m1[h1] && m1[h1] == m2[h2]) {
            cur_best = m1[h1];
            a = j - 1;
        }

        h1 = (((h1 - p1 * h[j - 1]) * SHUFFLE) + h[j + k - 1]) % MOD1;
        h2 = (((h2 - p2 * h[j - 1]) * SHUFFLE) + h[j + k - 1]) % MOD2;

        while (m1.count(h1) != 0) {
            if (m1[h1] == cur_best)
                a = j;
            ++j;
            h1 = (((h1 - p1 * h[j - 1]) * SHUFFLE) + h[j + k - 1]) % MOD1;
            h2 = (((h2 - p1 * h[j - 1]) * SHUFFLE) + h[j + k - 1]) % MOD2;
        }
    }

    for (int i = 0; i < k; ++i) {
        printf("%c", h[i + a]);
    }

    return 0;
}
