// github.com/andy489/

// http://codeforces.com/problemset/problem/514/D

// github.com/andy489/

// http://codeforces.com/problemset/problem/514/D

#include <iostream>
#include <vector>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

int n, m, k;

vector<int> log, temp, ans;
vector<vector<int>> a;
vector<vector<vector<int>>> st;

void log2() {
    log.resize(n + 1);

    for (int i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;

    st.assign(m, vector<vector<int>>(n, vector<int>(log[n] + 1)));
}

void build(int m) {
    for (int i = 0; i < n; ++i)
        st[m][i][0] = a[m][i];

    int k(log[n]);

    for (int j = 1; j <= k; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i)
            st[m][i][j] = max(st[m][i][j - 1], st[m][i + (1 << (j - 1))][j - 1]);
}

int query(int m, int L, int R) {
    int j = log[R - L + 1];
    return max(st[m][L][j], st[m][R - (1 << j) + 1][j]);
}

void init() {
    a.assign(m, vector<int>(n));

    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
            cin >> a[j][i];

    log2();

    temp.resize(m);
    ans.resize(m);

    for (int i = 0; i < m; ++i)
        build(i);
}

void solve() {
    int l(0), r(n - 1), mid;

    while (l <= r) {
        mid = (l + r) >> 1;
        bool possible(false);

        for (int L = 0, R = L + mid; R < n; ++L, ++R) {
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                temp[i] = query(i, L, R);
                sum += temp[i];
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
            r = mid - 1;
    }
    for (int i = 0; i < m; ++i)
        cout << ans[i] << ' ';
}

int main() {
    ios;
    cin >> n >> m >> k;
    return init(), solve(), 0;
}
