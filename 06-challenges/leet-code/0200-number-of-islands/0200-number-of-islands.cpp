// https://leetcode.com/problems/number-of-islands/

#include <vector>
#include <queue>
using namespace std;

// Solution: DFS with in-place marking — O(m·n) time, O(m·n) space
class Solution {
    static constexpr int DIRS[5] = {-1, 0, 1, 0, -1};

    void dfs(vector<vector<char>>& grid, int r, int c) {
        int m = grid.size(), n = grid[0].size();
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        for (int k = 0; k < 4; k++) {
            dfs(grid, r + DIRS[k], c + DIRS[k + 1]);
        }
    }

public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;

        for (int r = 0; r < (int)grid.size(); r++) {
            for (int c = 0; c < (int)grid[0].size(); c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }
};

// Solution 2: BFS with in-place marking — O(m·n) time, O(min(m,n)) space
class Solution2 {
    static constexpr int DIRS[5] = {-1, 0, 1, 0, -1};

public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size(), n = grid[0].size();
        int count = 0;

        queue<pair<int, int>> q;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0';
                    q.push({r, c});

                    while (!q.empty()) {
                        int cr = q.front().first;
                        int cc = q.front().second;
                        q.pop();

                        for (int k = 0; k < 4; k++) {
                            int nr = cr + DIRS[k];
                            int nc = cc + DIRS[k + 1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                q.push({nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
};
