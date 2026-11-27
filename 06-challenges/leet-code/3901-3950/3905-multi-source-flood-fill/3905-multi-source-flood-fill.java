// https://leetcode.com/problems/multi-source-flood-fill/
class Solution {
    public int[][] floodFill(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            java.util.Arrays.fill(row, -1);
        }
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        for (int[] src : sources) {
            int r = src[0], c = src[1], color = src[2];
            grid[r][c] = color;
            dist[r][c] = 0;
            queue.offer(new int[]{r, c});
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                int newDist = dist[r][c] + 1;
                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = newDist;
                    grid[nr][nc] = grid[r][c];
                    queue.offer(new int[]{nr, nc});
                } else if (dist[nr][nc] == newDist) {
                    grid[nr][nc] = Math.max(grid[nr][nc], grid[r][c]);
                }
            }
        }
        return grid;
    }
}
