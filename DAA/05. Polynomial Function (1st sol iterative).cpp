// github.com/andy489

// https://www.hackerrank.com/contests/rmq-test-1/challenges/polynomial-function/problem
// https://www.hackerrank.com/contests/tr-1585425135/challenges/poly-1-1

#include <cstdio>

using namespace std;

typedef long long ll;

const int mxN = 3e5 + 5, MOD = 1e9 + 7;
int n, k, q;
ll t[2 * mxN];

void build() {
    for (ll i = n - 1; i > 0; --i) t[i] = (t[i << 1] + t[i << 1 ^ 1]) % MOD;
}

void modify(int p, ll val) {
    for (t[p += n] = val; p > 1; p >>= 1) t[p >> 1] = (t[p] + t[p ^ 1]) % MOD;
}

ll query(int l, int r, ll res = 0) {
    for (l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
        if (l & 1) res = (res+t[l++]) % MOD;
        if (r & 1) res = (res+t[--r]) % MOD;
    }
    return res;
}

ll fast(ll a, int b, ll pow = 1) {
    while (b > 0) {
        if (b & 1)
            pow = (pow * a) % MOD;
        b >>= 1;
        a = a * a % MOD;
    }
    return pow;
}

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; ++i) {
        scanf("%lld", t + n + i);
        t[n + i] = t[n + i] * fast(k, n - i - 1);
    }
    build();
    int cmd; ll l, r;
    scanf("%d", &q);
    while (q--) {
        scanf("%d%lld%lld", &cmd, &l, &r);
        switch (cmd) {
            case 1:
                printf("%lld\n", query(l - 1, r - 1) * (fast(fast(k, n - r), MOD - 2)) % MOD);
                break;
            case 2:
                modify(l - 1, r * fast(k, n - l));
        }
    }
    return 0;
}
