// https://www.spoj.com/problems/RPLN/

#include <iostream>
#include <vector>

using namespace std;

const int mxN = 1e5;

vector<int> log2;
vector<vector<int>> sparse_table;

void preprocess_log_2() {
    log2.resize(mxN + 1);

    for (int i = 2; i <= mxN; ++i) {
        log2[i] = log2[i >> 1] + 1;
    }
}

void build_sparse_table(int n) {
    int k = log2[n];

    sparse_table.assign(k + 1, vector<int>(n + 1));

    for (int i = 0; i < n; ++i) {
        cin >> sparse_table[0][i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            sparse_table[j][i] = min(sparse_table[j - 1][i], sparse_table[j - 1][i + (1 << (j - 1))]);
        }
    }
}

int query(int L, int R) {
    int j = log2[R - L + 1];
    return min(sparse_table[j][L], sparse_table[j][R - (1 << j) + 1]);
}

void answer_queries() {
    int t;
    cin >> t;
    for (int i = 1; i <= t; ++i) {
        int n, q, L, R;
        cin >> n >> q;

        build_sparse_table(n);

        cout << "Scenario #" << i << ":" << endl;
        while (q--) {
            cin >> L >> R;
            --L, --R;

            cout << query(L, R) << endl;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    preprocess_log_2();

    answer_queries();

    return 0;
}
