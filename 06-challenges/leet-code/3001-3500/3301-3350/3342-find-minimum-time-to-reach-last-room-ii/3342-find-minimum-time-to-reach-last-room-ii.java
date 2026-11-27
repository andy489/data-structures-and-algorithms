// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/

// Solution: Dijkstra with Alternating Step Cost — O(n*m*log(n*m)) time, O(n*m) space
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        // dist[r][c][p]: min time at (r,c) with move parity p (0=next cost 1, 1=next cost 2)
        int[][][] dist = new int[n][m][2];
        for (int[][] mat : dist) for (int[] row : mat) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0][0] = 0;

        // [time, row, col, parity]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2], p = cur[3];
            if (t > dist[r][c][p]) continue;
            if (r == n - 1 && c == m - 1) return t;
            int cost = p == 0 ? 1 : 2;
            int np = 1 - p;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                int arrive = Math.max(t, moveTime[nr][nc]) + cost;
                if (arrive < dist[nr][nc][np]) {
                    dist[nr][nc][np] = arrive;
                    pq.offer(new int[]{arrive, nr, nc, np});
                }
            }
        }
        return Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
    }
}
