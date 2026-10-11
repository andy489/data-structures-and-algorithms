// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

vector<int> log2;
const int arr[] = {1, 2, -1, -2, 4, 1, -3, 3};
const int n = sizeof arr / sizeof arr[0];

void preprocess_log2(int n){
    log2.resize(n+1);
    
    for (int i = 2; i <= n; ++i) {
        log2[i] = log2[i / 2] + 1;
    }
}

int main() {
    preprocess_log2(n);
    
    int k = log2[n];
    
    vector<vector<int>> st(n + 1, vector<int>(k + 1));
    
    for (int i = 0; i < n; ++i) {
        st[i][0] = arr[i];
    }

    for (int j = 1; j <= k; ++j) {
        for (int i = 0; i + (1 << j) <= n; ++i) {
            st[i][j] = min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
        }
    }

    cout << "Enter number of queries [L, R]:" << endl;
    
    int q, L, R;
    cin >> q;

    while (q--) {
        cin >> L >> R;

        if (L < 1 || R > n || L > R) {
            cout << "Invalid interval" << endl;
            continue;
        }

        --L, --R;
        int j = log2[R - L + 1];
        int minimum = min(st[L][j], st[R - (1 << j) + 1][j]);

        cout << minimum << endl;
    }

    return 0;
}
