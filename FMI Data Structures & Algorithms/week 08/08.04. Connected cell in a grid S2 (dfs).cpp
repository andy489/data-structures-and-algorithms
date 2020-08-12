// github.com/andy489

// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

#include <iostream>
#include <vector>

using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

#define DIRECTIONS 8

vi xd{-1, -1, -1, 0, 0, 1, 1, 1}, yd{-1, 0, 1, -1, 1, -1, 0, 1};
int n, m;
vvi grid;

bool valid(int x, int y) {
    return x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0;
}

int dfs(int x, int y) {
    if (valid(x, y)) return 0;
    grid[x][y] = 0;
    int k, c(1);
    for (k = 0; k < DIRECTIONS; k++)
        c += dfs(x + xd[k], y + yd[k]);
    return c;
}

int main() {
    int i, j, area(0);
    cin >> n >> m;
    grid.assign(n, vi(m));

    for (i = 0; i < n; ++i)
        for (j = 0; j < m; ++j)
            cin >> grid[i][j];

    for (i = 0; i < n; ++i)
        for (j = 0; j < m; ++j)
            if (grid[i][j] != 0)
                area = max(area, dfs(i, j));

    return cout << area, 0;
}
