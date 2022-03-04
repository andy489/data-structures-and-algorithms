// https://www.hackerrank.com/challenges/queens-attack-2/problem

#include <iostream>
#include <set>

using namespace std;

const int BOARD_SIZE = 8;

int dx[]{1, 1, 1, 0, 0, -1, -1, -1};
int dy[]{-1, 0, 1, -1, 1, -1, 0, 1};
int n, c;

set<pair<int, int> > obs;

void dfs(int x, int y, int k) {
    if (min(x, y) < 1 || max(x, y) > n || obs.count({x, y})) {
        return;
    }

    c++;

    dfs(x + dx[k], y + dy[k], k);
}

int main() {
    int k, x, y, xx, yy;
    cin >> n >> k >> x >> y;

    while (k--) {
        cin >> xx >> yy;
        obs.insert({xx, yy});
    }

    for (k = 0; k < BOARD_SIZE; ++k) {
        dfs(x + dx[k], y + dy[k], k);
    }

    cout << c << endl;
    return 0;
}