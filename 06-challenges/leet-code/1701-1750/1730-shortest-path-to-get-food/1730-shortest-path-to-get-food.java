// https://leetcode.com/problems/shortest-path-to-get-food/

// Solution: BFS — O(m · n) time, O(m · n) space
class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 'X';
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cell[0] + dirs[d], nc = cell[1] + dirs[d + 1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 'X') {
                        continue;
                    }
                    if (grid[nr][nc] == '#') {
                        return dist;
                    }
                    grid[nr][nc] = 'X';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}
