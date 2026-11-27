// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Edge case: cannot leave starting cell
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        // Min-heap: {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];

            if (r == m - 1 && c == n - 1) {
                return t;
            }
            if (t > dist[r][c]) {
                continue;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                int nt = t + 1;
                if (nt < grid[nr][nc]) {
                    // Need to wait; parity adjustment
                    int diff = grid[nr][nc] - nt;
                    nt = grid[nr][nc] + (diff % 2 == 0 ? 0 : 1);
                }
                if (nt < dist[nr][nc]) {
                    dist[nr][nc] = nt;
                    pq.offer(new int[]{nt, nr, nc});
                }
            }
        }

        return -1;
    }
}
