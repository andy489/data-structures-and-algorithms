// https://codeforces.com/contest/475/problem/D
// https://codeforces.com/blog/entry/14168

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

typedef long long ll;

vector<vector<int>> sparse_table;
vector<int> logg2;
unordered_map<int, ll> answers;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

void preprocess_log2(int n) {
    logg2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        logg2[i] = logg2[i / 2] + 1;
    }
}

void build_sparse_table(int n) {
    int k = logg2[n];

    sparse_table.assign(k + 1, vector<int>(n + 1));

    for (int i = 0; i < n; ++i) {
        cin >> sparse_table[0][i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            sparse_table[j][i] = gcd(sparse_table[j - 1][i], sparse_table[j - 1][i + (1 << (j - 1))]);
        }
    }
}

int query(int L, int R) {
    int j = logg2[R - L + 1];
    return gcd(sparse_table[j][L], sparse_table[j][R - (1 << j) + 1]);
}

int bin_search_next(int val, int L, int R, int n) {
    int l = R;
    int r = n - 1;
    int mid;
    int pos;

    while (l <= r) {
        mid = l + (r - l) / 2;

        if (query(L, mid) == val) {
            pos = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }

    return pos + 1;
}

void get_answers_queries(int n) {
    int L, R, prevR;
    for (int i = 0; i < n; ++i) {
        L = R = prevR = i;
        int curr_gcd = sparse_table[0][i];

        while (R < n) {
            R = bin_search_next(curr_gcd, L, R, n);

            answers[curr_gcd] += R - prevR;
            prevR = R;

            if (R < n) {
                curr_gcd = gcd(curr_gcd, sparse_table[0][R]);
            }
        }
    }

    int q, x;
    cin >> q;

    while (q--) {
        cin >> x;
        cout << (answers.count(x) ? answers[x] : 0) << endl;
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    preprocess_log2(n);

    build_sparse_table(n);

    get_answers_queries(n);

    return 0;
}
