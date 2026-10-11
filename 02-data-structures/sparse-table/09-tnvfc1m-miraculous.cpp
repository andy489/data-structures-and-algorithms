// https://www.spoj.com/problems/TNVFC1M/

#include <cstdio>
#include <vector>

using namespace std;

int n, h, b, e;

vector<int> arr, log2, answers;
vector<vector<int>> sparse_table;

void preprocess_log2() {
    const int mxN = 1e4;
    log2.resize(mxN + 1);

    for (int i = 2; i <= mxN; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void init() {
    arr.assign(n, 0);
    answers.assign(n, 0);
    --b, --e;

    for (int i = 0; i < n; ++i) {
        scanf("%d", &arr[i]);
    }
}

void build_sparse_table() {
    int k = log2[n];
    sparse_table.assign(n, vector<int>(k + 1));

    for (int i = 0; i < n; ++i) {
        sparse_table[i][0] = i;
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            int c1 = sparse_table[i][j - 1], c2 = sparse_table[i + (1 << (j - 1))][j - 1];

            sparse_table[i][j] = (arr[c1] < arr[c2] ? c1 : c2);
        }
    }
}

int query(int L, int R) {
    int j = log2[R - L + 1];
    int c1 = sparse_table[L][j], c2 = sparse_table[R - (1 << j) + 1][j];

    return (arr[c1] < arr[c2] ? c1 : c2);
}

void answer_queries() {
    for (int i = n - 1; i >= 0; --i) {
        int L = max(b, i - h + 1);
        int c = query(L, i);

        ++answers[c];
    }
}

int main() {
    preprocess_log2();

    while (scanf("%d%d%d%d", &n, &h, &b, &e) != EOF) {

        init();

        build_sparse_table();

        answer_queries();

        for (int i = b; i <= e; ++i) {
            printf("%d\t", answers[i]);
        }

        printf("\n");
    }

    return 0;
}
