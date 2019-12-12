#include <bits/stdc++.h>
using namespace std;

static const int SIZE = 1 << 18;
static const int LOG2 = 18;

int n, q;
int arr[SIZE];

int log_2[SIZE];
int st[SIZE][LOG2];

void input() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
}

void build() {
    log_2[1] = 0;
    for (int i = 2; i < n; i++) {
        log_2[i] = log_2[i / 2] + 1;
    }

    for (int l = 0; l < n; l++) {
        st[l][0] = arr[l];
    }

    for (int i = 1; i < LOG2; i++) {
        for (int l = 0; l + (1 << i) <= n; l++) {
            st[l][i] = min(st[l][i - 1], st[l + (1 << (i - 1))][i - 1]);
        }
    }
}

int find_min(int l, int r) {
    int i = log_2[r - l + 1];
    return min(st[l][i], st[r - (1 << i) + 1][i]);
}

void solve() {
    cin >> q;
    for (int i = 0; i < q; i++) {
        int l, r;
        cin >> l >> r;
        cout << find_min(l, r) << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    input();
    build();
    solve();

    return 0;
}
