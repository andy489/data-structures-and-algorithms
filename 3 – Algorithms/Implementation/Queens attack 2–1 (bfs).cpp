// https://www.hackerrank.com/challenges/queens-attack-2/problem

#include <iostream>
#include <set>

using namespace std;

const int BOARD_SIZE = 8;

int main() {
    int dx[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[]{-1, 0, 1, -1, 1, -1, 0, 1};

    int n, k, x, y, xx, yy, c = 0;

    cin >> n >> k >> x >> y;

    set<pair<int, int> > bad;

    while (k--) {
        cin >> xx >> yy;
        bad.insert({xx, yy});
    }

    for (k = 0; k < BOARD_SIZE; ++k) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        while (true) {
            if (min(nx, ny) < 1 || max(nx, ny) > n || bad.count({nx, ny})) {
                break;
            }

            c++;

            nx += dx[k];
            ny += dy[k];
        }
    }

    cout << c << endl;

    return 0;
}
