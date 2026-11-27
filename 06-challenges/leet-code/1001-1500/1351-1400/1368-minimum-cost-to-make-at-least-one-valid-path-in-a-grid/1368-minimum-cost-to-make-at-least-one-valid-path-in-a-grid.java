// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

// Solution: 0-1 BFS — O(m*n) time, O(m*n) space
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d][0], nc = c + dirs[d][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                int cost = (grid[r][c] - 1 == d) ? 0 : 1;
                if (dist[r][c] + cost < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + cost;
                    if (cost == 0) dq.addFirst(new int[]{nr, nc});
                    else dq.addLast(new int[]{nr, nc});
                }
            }
        }
        return dist[m-1][n-1];
    }
}
