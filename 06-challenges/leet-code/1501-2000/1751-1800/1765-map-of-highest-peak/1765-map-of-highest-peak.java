// https://leetcode.com/problems/map-of-highest-peak/

// Solution: Multi-Source BFS — O(m*n) time, O(m*n) space
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && height[nr][nc] == -1) {
                    height[nr][nc] = height[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return height;
    }
}
