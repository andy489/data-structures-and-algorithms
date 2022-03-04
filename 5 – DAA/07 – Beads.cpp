#include <cstdio>
#include <vector>

using namespace std;

typedef long long ll;

int main() {
    const int MOD = 1e9 + 7;
    
    int n, k;
    scanf("%d%d", &n, &k);

    vector<ll> res(n + 1), lastBlue(n + 1), lastNotBlue(n + 1);

    res[1] = k, lastBlue[1] = 1, lastNotBlue[1] = k - 1;

    for (int i = 2; i <= n; ++i) {
        lastBlue[i] = lastNotBlue[i - 1];
        res[i] = (lastBlue[i - 1] * (k - 1) % MOD + lastNotBlue[i - 1] * k % MOD) % MOD;
        lastNotBlue[i] = (res[i] - lastBlue[i] + MOD) % MOD;
    }

    printf("%lld\n", res[n]);
    
    return 0;
}
