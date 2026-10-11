// https://www.hackerrank.com/challenges/lisa-workbook/problem

#include <iostream>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    int p = 1;
    int c = 0;
    for (int i = 0; i < n; ++i) {
        int t;
        cin >> t;

        for (int j = 0; j < t; ++j) {
            int q = p + j / k;
            if (q == j + 1) {
                ++c;
            }
        }
        p += (t + k - 1) / k;
    }

    cout << c << endl;
    
    return 0;
}