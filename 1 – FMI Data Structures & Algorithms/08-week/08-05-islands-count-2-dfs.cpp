// https://leetcode.com/problems/number-of-islands/

class Solution {
    const int DIR = 4;
    const vector<int> xd = {-1, 0, 1, 0};
    const vector<int> yd = {0, -1, 0, 1};

    int cnt = 0;
    int n;
    int m;
public:
    bool is_valid(int x, int y, vector <vector<char>> &grid) const {
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1';
    }

    void dfs(int x, int y, vector <vector<char>> &grid) const {
        if(grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';

        for (int i = 0; i < DIR; ++i) {
            if (is_valid(x + xd[i], y + yd[i], grid)) {
                dfs(x + xd[i], y + yd[i], grid);
            }
        }
    }

    int numIslands(vector<vector<char>> &grid) {
        n = grid.size();
        
        if (n == 0) {
            return 0;
        }
        
        m = grid[0].size();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ++cnt;
                }
            }
        }

        return cnt;
    }
};
