#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int inf = 1e9, NMAX=105;

#define forn(i, n) for (int i = 0; i < (int) n; ++i)
#define seta(a, b) memset(a, b, sizeof(a))

int n, m, k;
char s[NMAX];
int p[NMAX][NMAX], ans[NMAX][NMAX][27];

int main() {
    cin >> s >> k >> m;
    n = strlen(s);
    seta(p, 0);
    forn(i, m) {
        char c1[10], c2[10];
        int d;
        cin >> c1 >> c2 >> d;
        p[c1[0] - 'a'][c2[0] - 'a'] = d;
    }
    forn(i, n)s[i] = s[i] - 'a';

    forn(i, n + 1)forn(j, k + 1)forn(f, 27)ans[i][j][f] = -inf;

    forn(i, 26)ans[0][1][i] = 0;
    ans[0][0][s[0]] = 0;
    int tmp;
    forn(i, n + 1)
        forn(j, k + 1)
            forn(f, 26)
                if (ans[i][j][f] > -inf) {
                    forn(d, 26) {
                        tmp = 1;
                        if (s[i + 1] == d) tmp = 0;
                        ans[i + 1][j + tmp][d] = max(ans[i + 1][j + tmp][d], ans[i][j][f] + p[f][d]);
                    }
                }

    int answer = -inf;
    forn(i, k + 1)forn(j, 26)answer = max(answer, ans[n - 1][i][j]);
    cout << answer << endl;
    return 0;
}
