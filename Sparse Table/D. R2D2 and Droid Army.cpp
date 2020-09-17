// github.com/andy489/

// http://codeforces.com/problemset/problem/514/D

#include <iostream>
#include <vector>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

int n, m, k;

vector<vector<vector<int>>> st;
vector<vector<int>> a;
vector<int> log, temp, ans;

void log2() {
    log.resize(n + 1);
    for (int i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;
}

void build(int m) {
    for (int i = 0; i < n; ++i)
        st[m][i][0] = a[m][i];

    int k = log[n];
    for (int j = 1; j <= k; ++j)
        for (int i = 0; i <= n - (1 << j); ++i)
            st[m][i][j] = max(st[m][i][j - 1], st[m][i + (1 << (j - 1))][j - 1]);
}

long long query(int m, int L, int R) {
    int j = log[R - L + 1];
    return max(st[m][L][j], st[m][R - (1 << j) + 1][j]);
}

void solve() {
    int l = 1, r = n + 1;
    int mid;

    while (l < r) {
        mid = (l + r) >> 1;
        bool possible = false;

        for (int l = 0, r = l + mid - 1; r < n; ++l, ++r) {
            int sum = 0;
            for (int kk = 0; kk < m; ++kk) {
                temp[kk] = query(kk, l, r);
                sum += temp[kk];
            }
            if (sum <= k) {
                possible = true;
                break;
            }
        }
        if (possible) {
            for (int i = 0; i < m; ++i)
                ans[i] = temp[i];
            l = mid + 1;
        } else
            r = mid;
    }
}

int main() {
    ios;
    cin >> n >> m >> k;

    a.assign(m, vector<int>(n));

    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            cin >> a[j][i];

    log2();

    st.assign(m, vector<vector<int>>(n, vector<int>(log[n] + 1)));

    for (int i = 0; i < m; ++i)
        build(i);

    temp.resize(m);
    ans.resize(m);

    solve();

    for (int i = 0; i < m; ++i)
        cout << ans[i] << ' ';
    return 0;
}
