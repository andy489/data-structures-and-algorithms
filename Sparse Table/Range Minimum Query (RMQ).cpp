// github.com/andy489

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    vector<int> arr = {1, 2, -1, -2, 4, 1, -3, 3};

    int mxN = arr.size();
    int K = ceil(log2(mxN));

    vector<int> log(mxN + 1);
    vector<vector<int>> st(mxN + 1, vector<int>(K + 1));

    for (int i = 2; i <= mxN; ++i)
        log[i] = log[i / 2] + 1;

    for (int i = 0; i < mxN; ++i)
        st[i][0] = arr[i];

    for (int j = 1; j <= K; ++j)
        for (int i = 0; i + (1 << j) <= mxN; ++i) {
            st[i][j] = min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
        }
 
    cout << "Enter number of queries [L, R]:\n";
    int q, L, R;
    cin >> q;

    while (q--) {
        cin >> L >> R;
        if (L < 1 || R > mxN || L > R) {
            cout << "Invalid interval\n";
            continue;
        }
        --L, --R;
        int j = log[R - L + 1];
        int minimum = min(st[L][j], st[R - (1 << j) + 1][j]);
        cout << minimum << '\n';
    }

    return 0;
}
