// https://leetcode.com/problems/max-area-of-island/

// Solution: DFS — O(m·n) time, O(m·n) space
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}

// Solution 2: BFS — O(m·n) time, O(m·n) space
class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxArea = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        area++;
                        for (int[] d : dirs) {
                            int nr = cur[0] + d[0], nc = cur[1] + d[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                                grid[nr][nc] = 0;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
