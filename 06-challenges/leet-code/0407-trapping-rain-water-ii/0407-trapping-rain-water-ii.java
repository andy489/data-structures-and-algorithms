// https://leetcode.com/problems/trapping-rain-water-ii/

// Solution: Min-Heap BFS — O(m·n·log(m·n)) time, O(m·n) space
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        // min-heap: [waterLevel, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                    minHeap.offer(new int[]{heightMap[r][c], r, c});
                    visited[r][c] = true;
                }
            }
        }
        int water = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int level = cell[0], r = cell[1], c = cell[2];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                water += Math.max(0, level - heightMap[nr][nc]);
                minHeap.offer(new int[]{Math.max(level, heightMap[nr][nc]), nr, nc});
            }
        }
        return water;
    }
}
