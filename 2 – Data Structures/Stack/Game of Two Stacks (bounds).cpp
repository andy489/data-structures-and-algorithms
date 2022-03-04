// https://www.hackerrank.com/challenges/game-of-two-stacks/problem

#include <iostream>
#include <algorithm>

using namespace std;

const int mxN = 1e5 + 5;
long a[mxN], b[mxN];

int main() {
    int games;
    cin >> games;

    while (games--) {
        int n, m, x;
        cin >> n >> m >> x;

        for (int i = 0; i < n; ++i) {
            cin >> a[i];

            if (i) {
                a[i] += a[i - 1];
            }
        }
        for (int i = 0; i < m; ++i) {
            cin >> b[i];

            if (i) {
                b[i] += b[i - 1];
            }
        }

        long score = upper_bound(b, b + m, x) - b;

        for (int i = 0; i < n; ++i) {

            long r = upper_bound(b, b + m, x - a[i]) - b - 1;

            if (a[i] + b[r] <= x) {
                score = max(score, i + r + 2);
            }
        }

        cout << score << endl;
    }

    return 0;
}