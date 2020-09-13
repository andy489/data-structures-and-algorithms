// github.com/andy489

// https://www.codechef.com/problems/SEAD/
// https://discuss.codechef.com/t/sead-editorial/4626

#include <iostream>

using namespace std;

#define ios ios::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr)
#define K 17

const int MXN = 1e6 + 5, INF = 1e9;

int n, i, j, q, R, T, D;

int a[MXN], log[MXN], st[MXN][K];

void build() {
    log[1]=0;
    for (i = 2; i <= n; ++i)
        log[i] = log[i / 2] + 1;

    for (i = 0; i < n - 1; ++i)
        st[i][0] = a[i + 1] - a[i];

    for (j = 1; j < K; ++j)
        for (i = 0; i + (1 << j) < n; ++i)
            st[i][j] = max(st[i][j - 1], st[i + (1 << (j - 1))][j-1]);
}

int bs() {
    int l = 0, r = n;
    while (r - l > 1) {
        int mid = (l + r) >> 1;
        if (a[mid] <= T) l = mid;
        else r = mid;
    }
    return l;
}

bool validate(int L) {
    int left = L, right = R - 1;
    j = log[right - left + 1];
    int mx = max(st[left][j], st[right - (1 << j) + 1][j]);
    return mx <= D;
}

int bs_on_answer() {
    int l = -1, r = R;
    while (r - l > 1) {
        int mid = (l + r) >> 1;
        if (validate(mid)) r = mid;
        else l = mid;
    }
    return r + 1;
}

int main() {
    ios;
    cin >> n;
    for (; i < n; ++i)
        cin >> a[i];
    a[n] = INF;

    build();

    cin >> q;
    while (q--) {
        cin >> T >> D;
        R = bs();
        cout << bs_on_answer() << '\n';
    }
    return 0;
}
