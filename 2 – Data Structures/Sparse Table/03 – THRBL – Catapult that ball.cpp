// https://www.spoj.com/problems/THRBL/

#include <iostream>
#include <vector>

using namespace std;

vector<int> log2;

vector<vector<int>> sparse_table;

void preprocess_log_2(int n) {
    log2.resize(n + 1);

    log2[1] = 0;
    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void build_sparse_table(int n) {
    int k = log2[n];

    sparse_table.resize(k + 1, vector<int>(n + 1));

    for (int i = 0; i < n; ++i) {
        cin >> sparse_table[0][i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            sparse_table[j][i] = max(sparse_table[j - 1][i], sparse_table[j - 1][i + (1 << (j - 1))]);
        }
    }
}

void answer_queries(int q) {
    int A, B, answer = 0;
    while (q--) {
        cin >> A >> B;
        B -= 2;

        if (B - A == 0) {
            ++answer;
            continue;
        }

        int j = log2[B - A + 1];

        int maximum = max(sparse_table[j][A], sparse_table[j][B - (1 << j) + 1]);
        int L = sparse_table[0][A - 1];

        if (L >= maximum) {
            ++answer;
        }
    }

    cout << answer;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, q;
    cin >> n >> q;

    preprocess_log_2(n);

    build_sparse_table(n);

    answer_queries(q);

    return 0;
}