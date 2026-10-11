// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> grid;

bool is_valid(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < m && grid[x][y];
}

int bfs(int x, int y) {
    const int xd[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    const int yd[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    const int DIR = 8;

    queue<pair<int, int>> q;
    q.push({x, y});

    int cnt = 0;

    while (!q.empty()) {
        auto coord = q.front();
        q.pop();
        
        ++cnt;
        grid[coord.first][coord.second] = 0;

        for (int i = 0; i < DIR; ++i) {
            if (is_valid(coord.first + xd[i], coord.second + yd[i])) {
                q.push({coord.first + xd[i], coord.second + yd[i]});
                grid[coord.first + xd[i]][coord.second + yd[i]] = 0;
            }
        }
    }

    return cnt;
}

int main() {
    cin >> n >> m;

    grid.resize(n, vector<int>(m));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> grid[i][j];
        }
    }

    int max_area = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j]) {
                int curr_area = bfs(i, j);
                max_area = max(max_area, curr_area);
            }
        }
    }

    cout << max_area;

    return 0;
}
