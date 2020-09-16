// github.com/andy489

// https://codeforces.com/contest/475/problem/D

#include <unordered_map>

using namespace std;

typedef long long ll;
#define f first
#define s second

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    unordered_map<int, ll> temp, perm, ans;

    int n, i(0), x, q;
    scanf("%d", &n);
    for (; i < n; ++i) {
        scanf("%d", &x), temp.clear(), ++temp[x];
        for (const auto &j: perm)
            temp[gcd(x, j.f)] += j.s;
        swap(temp, perm);
        for (const auto &j: perm)
            ans[j.f] += j.s;
    }
    scanf("%d", &q);
    while (q--)
        scanf("%d", &x), ans.count(x) ? printf("%lld\n", ans[x]) : printf("0\n");
}
