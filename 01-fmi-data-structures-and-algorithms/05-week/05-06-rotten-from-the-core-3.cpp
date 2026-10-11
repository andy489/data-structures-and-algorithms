// https://www.hackerrank.com/contests/practice-5-sda/challenges/rotten-from-the-core

#include <iostream>

using namespace std;

int main() {
    int n, m, t, x1, y1, x2(1e5), y2(1e5), check;
    cin >> n >> m >> t >> x1 >> y1;

    if (cin >> check) {
        x2 = check;
        cin >> y2;
    }

    int not_rotten = m * n;

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            int dist1 = abs(x1 - i) + abs(y1 - j);
            int dist2 = abs(x2 - i) + abs(y2 - j);

            if (dist1 <= t || dist2 <= t) {
                --not_rotten;
            }
        }
    }

    cout << (not_rotten > 0 ? not_rotten : 0);

    return 0;
}
