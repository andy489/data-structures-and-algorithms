// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/

// Solution: Dijkstra's Algorithm — O(n*m*log(n*m)) time, O(n*m) space
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (t > dist[r][c]) continue;
            if (r == n - 1 && c == m - 1) return t;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                int arrive = Math.max(t, moveTime[nr][nc]) + 1;
                if (arrive < dist[nr][nc]) {
                    dist[nr][nc] = arrive;
                    pq.offer(new int[]{arrive, nr, nc});
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
