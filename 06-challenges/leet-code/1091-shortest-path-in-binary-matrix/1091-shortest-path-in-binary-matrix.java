// https://leetcode.com/problems/shortest-path-in-binary-matrix/

// Solution: BFS — O(n²) time, O(n²) space
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nr = cur[0]+d[0], nc = cur[1]+d[1];
                if (nr < 0||nr >= n||nc < 0||nc >= n||grid[nr][nc] != 0) continue;
                if (nr == n-1 && nc == n-1) return cur[2]+1;
                grid[nr][nc] = 1;
                q.offer(new int[]{nr, nc, cur[2]+1});
            }
        }
        return -1;
    }
}
