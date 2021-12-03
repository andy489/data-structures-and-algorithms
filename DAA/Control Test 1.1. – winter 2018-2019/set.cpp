#include <cstdio>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

typedef long long ll;

int main() {
    int n;
    ll k;
    scanf("%d %lld", &n, &k);

    vector<ll> v(n);
    unordered_set<ll> us;

    for (int i = 0; i < n; ++i) {
        scanf("%lld", &v[i]);
    }

    sort(v.begin(), v.end(), greater<int>());

    for (int i = 0; i < n; ++i) {
        if(!us.count(v[i] * k)){
            us.insert(v[i]);
        }
    }

    return printf("%lu", us.size()), 0;
}
