#include <iostream>

using namespace std;

const int SIZE = 1 << 18;

int n;
int arr[SIZE];
int bi_tree[SIZE];

void input() {
    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
}

void update(int index, int value) {
    ++index;

    while (index <= n) {
        bi_tree[index] += value;
        index += index & (-index);
    }
}

int find_sum(int index) {
    int sum = 0;
    ++index;

    while (index > 0) {
        sum += bi_tree[index];
        index -= index & (-index);
    }

    return sum;
}

void build() {
    for (int i = 0; i < n; i++) {
        update(i, arr[i]);
    }
}

void solve() {
    int q;
    cin >> q;

    for (int i = 0; i < q; ++i) {
        int l, r;
        cin >> l >> r;
        --l, --r;

        cout << find_sum(r) - find_sum(l - 1) << endl;
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
