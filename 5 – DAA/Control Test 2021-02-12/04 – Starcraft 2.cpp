// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/dp-2-todo-change-the-name

#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int INF = 1e9;
const int mxN = 105;
const int SIGMA = 26;

#define seta(a, b) memset(a, b, sizeof(a))

int n;
string s;

int p[mxN][mxN];
int ans[mxN][mxN][SIGMA + 1];

int main() {
    int m, k;
    cin >> s >> k >> m;

    n = s.size();

    seta(p, 0);

    string c1, c2;
    int d;
    while (m--) {
        cin >> c1 >> c2 >> d;

        p[c1[0] - 'a'][c2[0] - 'a'] = d;
    }

    for (int i = 0; i < n; ++i) {
        s[i] = s[i] - 'a';
    }

    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= k; ++j) {
            for (int f = 0; f <= SIGMA; ++f) {
                ans[i][j][f] = -INF;
            }
        }
    }

    for (int i = 0; i < SIGMA; ++i) {
        ans[0][1][i] = 0;
    }

    ans[0][0][s[0]] = 0;
    int tmp;
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= k; ++j) {
            for (int f = 0; f < SIGMA; ++f) {
                if (ans[i][j][f] > -INF) {
                    for (int d = 0; d < SIGMA; ++d) {
                        tmp = 1;

                        if (s[i + 1] == d) {
                            tmp = 0;
                        }

                        ans[i + 1][j + tmp][d] = max(ans[i + 1][j + tmp][d], ans[i][j][f] + p[f][d]);
                    }
                }
            }
        }
    }

    int answer = -INF;

    for (int i = 0; i <= k; ++i) {
        for (int j = 0; j < SIGMA; ++j) {
            answer = max(answer, ans[n - 1][i][j]);
        }
    }

    cout << answer;

    return 0;
}
