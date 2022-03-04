// http://codeforces.com/problemset/problem/514/D

#include <iostream>
#include <vector>

using namespace std;

int n, m, k;

vector<int> log, temp, ans;
vector<vector<int>> a;
vector<vector<vector<int>>> sparse_tables;

void init() {
    a.assign(m, vector<int>(n));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> a[j][i];
        }
    }
}

void preprocess_log2() {
    log.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log[i] = log[i / 2] + 1;
    }
}

void build_sparse_table(int p, int kk) {
    for (int i = 0; i < n; ++i) {
        sparse_tables[p][i][0] = a[p][i];
    }

    for (int j = 1; j <= kk; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            sparse_tables[p][i][j] = max(sparse_tables[p][i][j - 1], sparse_tables[p][i + (1 << (j - 1))][j - 1]);
        }
    }
}

void build_multiple_sparse_tables() {
    int kk = log[n];

    sparse_tables.resize(m, vector<vector<int>>(n, vector<int>(kk + 1)));
    temp.resize(m);
    ans.resize(m);

    for (int i = 0; i < m; ++i) {
        build_sparse_table(i, kk);
    }
}

int query(int i, int L, int R) {
    int j = log[R - L + 1];
    return max(sparse_tables[i][L][j], sparse_tables[i][R - (1 << j) + 1][j]);
}

void solve() {
    int l = 0;
    int r = n - 1;
    int mid;

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
            for (int i = 0; i < m; ++i) {
                ans[i] = temp[i];
            }

            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }

    for (int i = 0; i < m; ++i) {
        cout << ans[i] << ' ';
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> k;

    init();

    preprocess_log2();

    build_multiple_sparse_tables();

    solve();

    return 0;
}