#include <iostream>
#include <vector>

using namespace std;

const int MOD = 1e9 + 7;
typedef long long ll;

int n;
string s;
vector<int> res;
vector<ll> f;

void init() {
    cin >> s;
    n = s.size();
}

void processFibonacci(int n) {
    f.resize(n + 1);
    f[1] = 1, f[2] = 2;
    for (int i = 3; i <= n; ++i)
        f[i] = (f[i - 1] + f[i - 2]) % MOD;
}

void getRepetitions() {
    for (int i = 0; i < n; ++i) {
        if (s[i] == 'm' || s[i] == 'w')
            printf("%d", 0), exit(0);
        if (s[i] == 'n' || s[i] == 'u') {
            int j = i + 1;
            for (; j < n && s[j] == s[j - 1]; ++j) {}
            int curr = j - i;
            res.push_back(curr);
            i = j - 1;
        }
    }
}

int calcAnswer(ll ans = 1) {
    for (int x: res) ans = (ans * f[x] % MOD);
    return ans;
}

int main() {
    return init(), processFibonacci(n), getRepetitions(), printf("%d\n", calcAnswer()), 0;
}
