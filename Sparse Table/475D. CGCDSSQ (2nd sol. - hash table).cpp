// github.com/andy489

// https://codeforces.com/contest/475/problem/D

#include <unordered_map>

using namespace std;

typedef long long ll;
#define f first
#define s second

unordered_map<int, ll> temp, perm, ans;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    int n, i(0), x;
    scanf("%d", &n);
    for (; i < n; ++i) {
        scanf("%d", &x), temp.clear(), ++temp[x];
        for (const auto &j: perm)
            temp[gcd(x, j.f)] += j.s;
        swap(temp, perm);
        for (const auto &j: perm)
            ans[j.f] += j.s;
    }
    int q;
    scanf("%d", &q);
    while (q--)
        scanf("%d", &x), printf("%lld\n", ans[x]);
}
