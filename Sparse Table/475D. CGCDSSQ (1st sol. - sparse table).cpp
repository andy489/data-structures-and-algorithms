// github.com/andy489

// https://codeforces.com/contest/475/problem/D

// https://codeforces.com/blog/entry/14168

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define rep(i, s, e) for(int i=s; i<e; ++i)

typedef long long ll;

vector<vector<int>> st;
vector<int> arr, logarithm;
unordered_map<int, ll> ans;
int n;

int GCD(int a, int b) {
    return b == 0 ? a : GCD(b, a % b);
}

void build() {
    logarithm.resize(n + 1);
    rep(i, 2, n + 1) logarithm[i] = logarithm[i / 2] + 1;

    int K = logarithm[n];
    st.assign(n, vector<int>(K + 1));
    rep(i, 0, n) st[i][0] = arr[i];

    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i)
            st[i][j] = GCD(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
}

int query(int L, int R) {
    int j = logarithm[R - L + 1];
    return GCD(st[L][j], st[R - (1 << j) + 1][j]);
}

int next(int val, int L, int R) {
    int l = R, r = n - 1, mid, pos;
    while (l <= r) {
        mid = (l + r) >> 1;
        if (query(L, mid) == val) {
            pos = mid;
            l = mid + 1;
        } else
            r = mid - 1;
    }
    return pos + 1;
}

void solve() {
    build();

    int L, R, prevR;
    rep(i, 0, n) {
        L = R = prevR = i;
        int currGCD = arr[i];
        while (R < n) {
            R = next(currGCD, L, R);
            ans[currGCD] += R - prevR;
            prevR = R;
            if (R < n)
                currGCD = GCD(currGCD, arr[R]);
        }
    }
}

int main() {
    ios;
    cin >> n;

    arr.resize(n);
    rep(i, 0, n) cin >> arr[i];

    solve();

    int q, x;
    cin >> q;
    while (q--) {
        cin >> x;
        cout << (ans.count(x) ? ans[x] : 0) << '\n';
    }

    return 0;
}
