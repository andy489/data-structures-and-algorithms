// https://leetcode.com/problems/swim-in-rising-water/

// Solution: Min-Heap (Dijkstra-style) — O(n² log n) time, O(n²) space
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        heap.offer(new int[]{grid[0][0], 0, 0});
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            if (r == n - 1 && c == n - 1) {
                return t;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    heap.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1;
    }
}
