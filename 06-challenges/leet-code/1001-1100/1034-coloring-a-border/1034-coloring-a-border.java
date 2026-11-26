// https://leetcode.com/problems/coloring-a-border/

// Solution: BFS + Border Detection — O(m*n) time, O(m*n) space
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int origColor = grid[row][col];
        boolean[][] visited = new boolean[m][n];
        List<int[]> component = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            component.add(cur);
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == origColor) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        for (int[] cell : component) {
            int r = cell[0], c = cell[1];
            boolean isBorder = r == 0 || r == m-1 || c == 0 || c == n-1;
            if (!isBorder) {
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (grid[nr][nc] != origColor) { isBorder = true; break; }
                }
            }
            if (isBorder) { grid[r][c] = color; }
        }
        return grid;
    }
}
