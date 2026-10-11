// https://www.codechef.com/problems/MSTICK

#include <iostream>
#include <iomanip>
#include <vector>

using namespace std;

vector<int> log2;

vector<vector<int>> mini;
vector<vector<int>> maxi;

int get_min(int L, int R) {
    int j = log2[R - L + 1];

    return min(mini[j][L], mini[j][R - (1 << j) + 1]);
}

int get_max(int L, int R) {
    if (L > R) {
        return 0;
    }

    int j = log2[R - L + 1];

    return max(maxi[j][L], maxi[j][R - (1 << j) + 1]);
}

void preprocess_log_2(int n) {
    log2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void build_sparse_table(int n) {
    int k = log2[n];

    mini.resize(k + 1, vector<int>(n + 1));
    maxi.resize(k + 1, vector<int>(n + 1));

    int b;
    for (int i = 0; i < n; ++i) {
        cin >> b;
        mini[0][i] = maxi[0][i] = b;
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i <= n - (1 << j); ++i) {
            mini[j][i] = min(mini[j - 1][i], mini[j - 1][i + (1 << (j - 1))]);
            maxi[j][i] = max(maxi[j - 1][i], maxi[j - 1][i + (1 << (j - 1))]);
        }
    }
}

void answer_queries(int n) {
    int q;
    cin >> q;

    int L, R;
    while (q--) {
        cin >> L >> R;

        int max_1 = get_min(L, R) + get_max(L, R);
        int max_2 = max(get_max(0, L - 1), get_max(R + 1, n - 1)) + get_min(L, R);

        int answer = max(max_1, max_2 * 2);

        cout << fixed << setprecision(1) << answer / 2.0 << endl;
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