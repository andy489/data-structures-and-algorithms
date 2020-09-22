// github.com/andy489

// https://devskill.com/CodingProblems/ViewProblem/19

#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)

int n, q, L, R;

vector<int> a, log;
vector<vector<int>> st;

void init() {
    a.resize(n);
    for (int i = 0; i < n; ++i)
        cin >> a[i];

    log.resize(n + 1);
    for (int i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;
}

void build() {
    int K(log[n]);
    st.assign(n, vector<int>(K + 1));

    for (int i = 0; i < n; ++i)
        st[i][0] = i;

    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i) {
            int l = st[i][j - 1], r = st[i + (1 << (j - 1))][j - 1];
            st[i][j] = (a[l] <= a[r] ? l : r);
        }
}

int query(int L, int R) {
    int j = log[R - L + 1];
    int c1 = st[L][j], c2 = st[R - (1 << j) + 1][j];
    return (a[c1] <= a[c2] ? c1 : c2);
}

int main() {
    ios;
    int t;
    string blank;
    cin >> t;
    getline(cin, blank); // reads the rest of the line that the number was on
    getline(cin, blank);  // reads the blank line


    for (int i = 1; i <= t; ++i) {
        cin >> n >> q;
        init();
        build();
        cout << "Case " << i << ":\n";
        while (q--) {
            cin >> L >> R;
            --L, --R;
            if (L == R) {
                cout << a[L] << ' ' << L + 1 << ' ' << L + 1 << '\n';
                continue;
            }

            int index = query(L, R);
            if (!a[index])
                cout << 0 << ' ' << L + 1 << ' ' << R + 1 << '\n';
            else if (a[index] > 1)
                cout << a[index] << ' ' << index + 1 << ' ' << index + 1 << '\n';
            else { // a[index] == 1 and index is most-left
                if (index == R && L != R) {
                    cout << 1 << ' ' << index + 1 << ' ' << index + 1 << '\n';
                    continue;
                }

                int maxLen(0), maxStart(0);

                while (index <= R && a[query(index, R)] == 1) {
                    int start = query(index, R);
                    int len = 0;
                    while (a[start + len] == 1 && start + len <= R) {
                        len++;
                    }
                    if (len > maxLen) {
                        maxLen = len;
                        maxStart = start;
                    }
                    index += len;
                }
                cout << 1 << ' ' << maxStart + 1 << ' ' << maxStart + maxLen << '\n';
            }
        }
        if (i != t) {
            getline(cin, blank);
            getline(cin, blank);
        }
    }
    return 0;
}
