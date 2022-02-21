// https://www.hackerrank.com/challenges/lisa-workbook/problem

#include <iostream>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    int a[n];

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    int c = 0;
    int pg = 1;

    for (int i = 0; i < n; ++i) {
        for (int j = 1; j <= a[i]; ++j) {
            if (j == pg) {
                ++c;
            }
            if (j % k == 0 && j < a[i]) {
                ++pg;
            }
        }
        ++pg;
    }

    cout << c;
    return 0;
}
