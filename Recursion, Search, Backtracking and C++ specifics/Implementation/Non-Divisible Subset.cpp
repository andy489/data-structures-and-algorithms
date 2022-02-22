// https://www.hackerrank.com/challenges/non-divisible-subset/problem

#include <iostream>

using namespace std;

const int MAX_REM = 100;

int main() {
    int n, k, a;
    int res = 0;
    int *r = new int[MAX_REM];

    cin >> n >> k;

    for (int i = 0; i < n; ++i) {
        cin >> a;
        ++r[a % k];
    }

    int end = (k + 1) / 2;

    for (int i = 1; i < end; ++i) {
        res += (r[i] > r[k - i] ? r[i] : r[k - i]);
    }

    if (r[0]) {
        ++res;
    }
    if (!(k & 1) && r[k / 2]) {
        ++res;
    }

    cout << res << endl;
}
