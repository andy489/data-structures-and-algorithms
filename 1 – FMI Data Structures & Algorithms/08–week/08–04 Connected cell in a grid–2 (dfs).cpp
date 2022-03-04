// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem

#include <iostream>
#include <vector>

using namespace std;

const int xd[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int yd[] = {-1, 0, 1, -1, 1, -1, 0, 1};
const int DIR = 8;
int n, m;

vector<vector<int>> grid;

bool is_valid(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < m && grid[x][y];
}

int dfs(int x, int y) {
    if (!is_valid(x, y)) {
        return 0;
    }
    
    grid[x][y] = false;
    int  cnt = 1;
    
    for (int i = 0; i < DIR; ++i) {
        cnt += dfs(x + xd[i], y + yd[i]);
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
            if (grid[i][j] != 0) {
                int curr_area = dfs(i, j);
                max_area = max(max_area, curr_area);
            }
        }
    }
    
    cout << max_area;

    return 0;
}