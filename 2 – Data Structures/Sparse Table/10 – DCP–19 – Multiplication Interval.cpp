// https://devskill.com/CodingProblems/ViewProblem/19

#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

vector<int> arr, log2;
vector<vector<int>> st;

void preprocess_log2(int n) {
    log2.resize(n + 1);

    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

void init(int n) {
    arr.resize(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
}

void build_sparse_table(int n) {
    int k = log2[n];
    st.assign(n, vector<int>(k + 1));

    for (int i = 0; i < n; ++i) {
        st[i][0] = i;
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            int l = st[i][j - 1], r = st[i + (1 << (j - 1))][j - 1];
            st[i][j] = (arr[l] <= arr[r] ? l : r);
        }
    }
}

int query(int L, int R) {
    int j = log2[R - L + 1];

    int c1 = st[L][j];
    int c2 = st[R - (1 << j) + 1][j];

    return (arr[c1] <= arr[c2] ? c1 : c2);
}

int main() {
    ios;
    int t;
    string blank;

    cin >> t;
    getline(cin, blank); // reads the rest of the line that the number was on
    getline(cin, blank); // reads the blank line

    int n, q;
    for (int i = 1; i <= t; ++i) {
        cin >> n >> q;

        init(n);

        preprocess_log2(n);

        build_sparse_table(n);

        cout << "Case " << i << ":" << endl;

        int L, R;
        while (q--) {
            cin >> L >> R;
            --L, --R;

            if (L == R) {
                cout << arr[L] << ' ' << L + 1 << ' ' << L + 1 << endl;
                continue;
            }

            int index = query(L, R);
            if (!arr[index]) {
                cout << 0 << ' ' << L + 1 << ' ' << R + 1 << endl;
            } else if (arr[index] > 1) {
                cout << arr[index] << ' ' << index + 1 << ' ' << index + 1 << endl;
            } else { // arr[index] == 1 and index is most-left
                if (index == R && L != R) {
                    cout << 1 << ' ' << index + 1 << ' ' << index + 1 << endl;
                    continue;
                }

                int max_len = 0;
                int max_start = 0;

                while (index <= R && arr[query(index, R)] == 1) {
                    int start = query(index, R);
                    int len = 0;

                    while (arr[start + len] == 1 && start + len <= R) {
                        ++len;
                    }

                    if (len > max_len) {
                        max_len = len;
                        max_start = start;
                    }

                    index += len;
                }

                cout << 1 << ' ' << max_start + 1 << ' ' << max_start + max_len << endl;
            }
        }

        if (i != t) {
            getline(cin, blank);
            getline(cin, blank);
        }
    }

    return 0;
}