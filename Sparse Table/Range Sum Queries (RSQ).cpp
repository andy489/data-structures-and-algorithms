// github.com/andy489

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    vector<int> arr = {1, 2, -1, 3, 1, -2, 1, 4};

    int mxN = arr.size();
    int K = ceil(log2(mxN));

    vector<vector<int>> st(mxN + 1, vector<int>(K + 1));

    for (int i = 0; i < mxN; ++i)
        st[i][0] = arr[i];

    for (int j = 1; j <= K; ++j) {
        for (int i = 0; i + (1 << j) <= mxN; ++i) {
            st[i][j] = st[i][j - 1] + st[i + (1 << (j - 1))][j - 1];
        }
    }

    int q, L, R;
    cout << "Enter number of range sum queries of the form \"L R\":\n";
    cin >> q;
    while (q--) {
        cin >> L >> R;
        if (L < 1 || R > mxN || L > R) {
            cout << "Invalid interval\n";
            continue;
        }
        --L, --R;
        long long sum = 0;
        for (int j = K; j >= 0; --j) {
            if ((1 << j) <= R - L + 1) {
                sum += st[L][j];
                L += 1 << j;
            }
        }
        cout << sum << '\n';
    }

    return 0;
}
