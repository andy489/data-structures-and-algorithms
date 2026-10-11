// https://www.codechef.com/problems/SEAD/
// https://discuss.codechef.com/t/sead-editorial/4626

#include <iostream>
#include <vector>

using namespace std;

const int INF = 1e9;

vector<int> log2;
vector<int> arr;
vector<vector<int>> sparse_table;

void preprocess_log_2(int n) {
    log2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void build_sparse_table(int n) {
    arr.resize(n + 1);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    arr[n] = INF;

    int k = log2[n];

    sparse_table.resize(k + 1, vector<int>(n + 1));

    for (int i = 0; i < n - 1; ++i) {
        sparse_table[0][i] = arr[i + 1] - arr[i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) < n; ++i) {
            sparse_table[j][i] = max(sparse_table[j - 1][i], sparse_table[j - 1][i + (1 << (j - 1))]);
        }
    }
}

int bin_search(int n, int T) {
    int l = 0;
    int r = n;
    int mid;

    while (l + 1 < r) {
        mid = l + (r - l) / 2;

        if (arr[mid] <= T) {
            l = mid;
        } else {
            r = mid;
        }
    }

    return l;
}

bool validate(int L, int R, int D) {
    int left = L;
    int right = R - 1;

    int j = log2[right - left + 1];

    int mx = max(sparse_table[j][left], sparse_table[j][right - (1 << j) + 1]);

    return mx <= D;
}

int bin_search_on_ans(int R, int D) {
    int l = -1;
    int r = R;
    int mid;

    while (l + 1 < r) {
        mid = l + (r - l) / 2;

        if (validate(mid, R, D)) {
            r = mid;
        } else {
            l = mid;
        }
    }

    return r + 1;
}

void answer_queries(int n) {
    int q;
    cin >> q;

    int T, D;
    while (q--) {
        cin >> T >> D;

        int R = bin_search(n, T);
        cout << bin_search_on_ans(R, D) << endl;
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

    answer_queries(n);

    return 0;
}
