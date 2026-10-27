// https://leetcode.com/problems/number-of-islands/

// Solution: DFS with in-place marking — O(m·n) time, O(m·n) space
class Solution {
    private static final int[] DIRS = {-1, 0, 1, 0, -1};

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        for (int k = 0; k < 4; k++) {
            dfs(grid, r + DIRS[k], c + DIRS[k + 1]);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }
}

// Solution 2: BFS with in-place marking — O(m·n) time, O(min(m,n)) space
class Solution2 {
    private static final int[] DIRS = {-1, 0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0';
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = cell[0] + DIRS[k];
                            int nc = cell[1] + DIRS[k + 1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
