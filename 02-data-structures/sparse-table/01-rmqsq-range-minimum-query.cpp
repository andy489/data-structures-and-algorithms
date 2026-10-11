// https://www.spoj.com/problems/RMQSQ/

#include <iostream>
#include <vector>

using namespace std;

vector<int> log2;
vector<vector<int>> sparse_table;

void build_sparse_table(int n) {
    int k = log2[n];
    sparse_table.resize(k + 1, vector<int>(n + 1));

    for (int i = 0; i < n; ++i) {
        cin >> sparse_table[0][i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            sparse_table[j][i] = min(sparse_table[j - 1][i], sparse_table[j - 1][i + (1 << (j - 1))]);
        }
    }
}

void preprocess_log_2(int n) {
    log2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void answer_queries() {
    int q;
    cin >> q;

    int L, R;

    while (q--) {
        cin >> L >> R;
        int j = log2[R - L + 1];

        cout << min(sparse_table[j][L], sparse_table[j][R - (1 << j) + 1])
             << endl;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    preprocess_log_2(n);

    build_sparse_table(n);

    answer_queries();

    return 0;
}
