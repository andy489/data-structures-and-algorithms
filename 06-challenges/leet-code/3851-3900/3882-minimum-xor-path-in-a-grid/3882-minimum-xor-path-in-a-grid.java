// https://leetcode.com/problems/minimum-xor-path-in-a-grid/

class Solution {
    public int minXorPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        // priority queue: [xorVal, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[] dr = {0, 1};
        int[] dc = {1, 0};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int xor = cur[0], r = cur[1], c = cur[2];
            if (xor > dist[r][c]) {
                continue;
            }
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < m && nc < n) {
                    int nx = xor ^ grid[nr][nc];
                    if (nx < dist[nr][nc]) {
                        dist[nr][nc] = nx;
                        pq.offer(new int[]{nx, nr, nc});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
