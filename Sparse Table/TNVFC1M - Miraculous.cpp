// github.com/andy489

// https://www.spoj.com/problems/TNVFC1M/

#include <stdio.h>
#include <vector>

using namespace std;

int n, h, b, e;

vector<int> a, log, ans;
vector<vector<int>> st;

void build() {
    log.resize(n + 1);
    for (int i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;

    int K(log[n]);
    st.assign(n, vector<int>(K + 1));
    for (int i = 0; i < n; ++i)
        st[i][0] = i;

    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= n; ++i) {
            int c1 = st[i][j - 1], c2 = st[i + (1 << (j - 1))][j - 1];
            st[i][j] = (a[c1] < a[c2] ? c1 : c2);
        }
}

int query(int L, int R) {
    int j = log[R - L + 1];
    int c1 = st[L][j], c2 = st[R - (1 << j) + 1][j];
    return (a[c1] < a[c2] ? c1 : c2);
}

void solve() {
    while (scanf("%d%d%d%d", &n, &h, &b, &e) != EOF) {
        a.resize(n);
        ans.assign(n, 0);
        --b, --e;

        for (int i = 0; i < n; ++i)
            scanf("%d", &a[i]);

        build();

        for (int i = n - 1; i >= 0; --i) {
            int L = max(b, i - h + 1);
            int c = query(L, i);
            ++ans[c];
        }
        for (int i = b; i <= e; ++i)
            printf("%d\t", ans[i]);
        printf("\n");
    }
}

int main() {
    return solve(), 0;
}
