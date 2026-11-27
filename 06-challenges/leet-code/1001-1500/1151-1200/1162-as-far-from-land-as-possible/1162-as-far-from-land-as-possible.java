// https://leetcode.com/problems/as-far-from-land-as-possible/

// Solution: Multi-Source BFS — O(n²) time, O(n²) space
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        if (q.isEmpty() || q.size() == n * n) {
            return -1;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    grid[nr][nc] = grid[cur[0]][cur[1]] + 1;
                    dist = grid[nr][nc] - 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}
