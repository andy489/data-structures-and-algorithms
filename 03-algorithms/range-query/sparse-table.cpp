#include <iostream>
#include <vector>

using namespace std;

int n;

vector<int> log_2;
vector<vector<int>> sparse_table;

void preprocess_log_2() {
    log_2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log_2[i] = log_2[i / 2] + 1;
    }
}

void build() {
    int k = log_2[n];
    sparse_table.resize(n + 1, vector<int>(k + 1));

    for (int i = 0; i < n; ++i) {
        cin >> sparse_table[i][0];
    }

    for (int i = 1; i <= k; ++i) {
        for (int l = 0; l + (1 << i) <= n; l++) {
            sparse_table[l][i] = min(sparse_table[l][i - 1], sparse_table[l + (1 << (i - 1))][i - 1]);
        }
    }
}

int find_min(int l, int r) {
    int i = log_2[r - l + 1];
    return min(sparse_table[l][i], sparse_table[r - (1 << i) + 1][i]);
}

void solve() {
    int q;
    cin >> q;

    for (int i = 0; i < q; ++i) {
        int l, r;
        cin >> l >> r;
        --l, --r;

        cout << find_min(l, r) << endl;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    preprocess_log_2();

    build();

    solve();

    return 0;
}
