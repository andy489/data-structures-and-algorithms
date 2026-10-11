// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
typedef unsigned long long ll;

const int BASE = 257;
const ll P = 10e13 + 39; // prime

struct Rolling_Stone { // also known as Rolling_Hash, Rolling_Window etc.
    vector<ll> hash, magic;
    ll _mod;

    explicit Rolling_Stone(const string &s, int base = BASE, ll mod = P) {
        const int SIZE = s.size();

        hash.assign(SIZE + 1, 0); // suf[n] = 0
        magic.assign(SIZE + 1, 0);

        magic[0] = 1;
        magic[1] = base;
        _mod = mod;

        for (int i = SIZE - 1; i >= 0; --i) {
            hash[i] = (s[i] + hash[i + 1] * magic[1]) % mod;
        }

        for (int i = 2; i <= SIZE; ++i) {
            magic[i] = magic[i - 1] * magic[1] % mod;
        }
    }

    [[nodiscard]] ll substr(int l, int r) const { // [l, r] our rolling window
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

    int n, k;

    cin >> n >> k;
    cin.ignore();

    string txt;
    getline(cin, txt);

    Rolling_Stone rh(txt);
    unordered_map<ll, int> um;

    int cnt;
    int max_index = 2019;
    int c = 0;

    for (int i = k; i <= n; ++i) {
        ll key = rh.substr(i - k, i - 1);
        um[key]++;
        cnt = um[key];

        if (cnt >= c) {
            c = um[key];
            max_index = i - k;
        }
    }

    for (int i = max_index; i < max_index + k; ++i) {
        cout << txt[i];
    }

    return 0;
}
