// github.com/andy489

// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool isValid(int x, int y, int n, int m, vector<vector<int>> &grid) {
    return x < n && y < m && x >= 0 && y >= 0 && grid[x][y] == 1;
}

int bfs(int x, int y, vector<vector<int>> &grid, int n, int m) {
    int xd[] = {-1, -1, -1, 0, 0, 1, 1, 1},
            yd[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    queue<pair<int, int>> Q;
    Q.push({x, y});

    int cnt(0), SIZE(8), i;

    while (!Q.empty()) {
        auto coord = Q.front();
        Q.pop();
        ++cnt;
        grid[coord.first][coord.second] = 0;

        for (i = 0; i < SIZE; ++i) {
            if (isValid(coord.first + xd[i], coord.second + yd[i], n, m, grid)) {
                Q.push({coord.first + xd[i], coord.second + yd[i]});
                grid[coord.first + xd[i]][coord.second + yd[i]] = 0;
            }
        }
    }
    return cnt;
}

int main() {
    int n, m, i(0), j, area(0);
    cin >> n >> m;

    vector<vector<int>> grid(n, vector<int>(m));

    for (i = 0; i < n; ++i)
        for (j = 0; j < m; ++j)
            cin >> grid[i][j];

    for (i = 0; i < n; ++i)
        for (j = 0; j < m; ++j)
            if (grid[i][j])
                area = max(area, bfs(i, j, grid, n, m));

    return cout << area, 0;
}
