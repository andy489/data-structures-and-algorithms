#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    vector<int> arr = {1, 2, -1, 3, 1, -2, 1, 4};

    int n = arr.size();
    int k = ceil(log2(n));

    vector<vector<int>> st(n + 1, vector<int>(k + 1));

    for (int i = 0; i < n; ++i) {
        st[i][0] = arr[i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            st[i][j] = st[i][j - 1] + st[i + (1 << (j - 1))][j - 1];
        }
    }

    int q, L, R;
    cout << "Enter number of range sum queries of the form \"L R\":" << endl;

    cin >> q;
    while (q--) {
        cin >> L >> R;
        if (L < 1 || R > n || L > R) {
            cout << "Invalid interval" << endl;
            continue;
        }

        --L, --R;
        long long sum = 0;
        for (int j = k; j >= 0; --j) {
            if ((1 << j) <= R - L + 1) {
                sum += st[L][j];
                L += 1 << j;
            }
        }

        cout << sum << endl;
    }

    return 0;
}
