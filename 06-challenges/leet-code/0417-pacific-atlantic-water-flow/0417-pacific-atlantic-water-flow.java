// https://leetcode.com/problems/pacific-atlantic-water-flow/

// Solution: Reverse BFS from Ocean Borders — O(m*n) time, O(m*n) space
class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            pacificQueue.offer(new int[]{r, 0});
            atlanticQueue.offer(new int[]{r, n - 1});
            pacific[r][0] = true;
            atlantic[r][n - 1] = true;
        }
        for (int c = 0; c < n; c++) {
            pacificQueue.offer(new int[]{0, c});
            atlanticQueue.offer(new int[]{m - 1, c});
            pacific[0][c] = true;
            atlantic[m - 1][c] = true;
        }

        bfs(heights, pacificQueue, pacific, m, n);
        bfs(heights, atlanticQueue, atlantic, m, n);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited, int m, int n) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : DIRS) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && !visited[nr][nc]
                        && heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
