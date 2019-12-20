#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
typedef unsigned long long ll;
#define BASE 257 
#define P (ll)10e13+39
struct RollingStone { // RollingHash, RollingWindow etc.
    vector<ll> hash, magic;
    ll _mod;

    RollingStone(const string& s, int base = BASE, ll mod = P) {
        int n(s.size()),i;
        hash.assign(n + 1, 0); // suf[n] = 0
        magic.assign(n + 1, 0);
        magic[0] = 1;
        magic[1] = base;
        _mod = mod;
        for (i = n - 1; i >= 0; --i) {
            hash[i] = (s[i] + hash[i + 1] * magic[1]) % mod;
        }
        for (i = 2; i <= n; ++i) {
            magic[i] = magic[i - 1] * magic[1] % mod;
        }
    }

    ll substr(int l, int r) const { // [l, r] our rolling window
        ll v = hash[l] - hash[r + 1] * magic[r - l + 1];
        v %= _mod;
        v += _mod;
        v %= _mod;
        return v;
    }
};

int main() {
    cin.tie(nullptr);
    cin.sync_with_stdio(false);
    int n, k, i, c(0),count, maxIndx(2019);
    
    cin >> n >> k;
    cin.ignore();
    
    string txt;
    getline(cin, txt);

    RollingStone rh(txt);
    unordered_map<ll, int> um;

    for (i = k; i <= n; ++i) {        
        ll key = rh.substr(i - k, i - 1);
        um[key]++;
        count = um[key];
        if (count >= c) {
            c = um[key];
            maxIndx = i - k;
        }
    }
    for (i = maxIndx;i < maxIndx + k;++i) cout << txt[i];
    return 0;
}
