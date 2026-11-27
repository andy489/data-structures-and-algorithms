// https://leetcode.com/problems/path-with-minimum-effort/

// Solution: Dijkstra's Algorithm — O(rows * cols * log(rows * cols)) time, O(rows * cols) space
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int e = cur[0], r = cur[1], c = cur[2];
            if (e > effort[r][c]) {
                continue;
            }
            if (r == rows - 1 && c == cols - 1) {
                return e;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int ne = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (ne < effort[nr][nc]) {
                        effort[nr][nc] = ne;
                        pq.offer(new int[]{ne, nr, nc});
                    }
                }
            }
        }
        return effort[rows - 1][cols - 1];
    }
}
