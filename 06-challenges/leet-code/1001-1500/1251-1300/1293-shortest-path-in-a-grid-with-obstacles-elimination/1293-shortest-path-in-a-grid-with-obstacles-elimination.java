// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

// Solution: BFS with State (r, c, k_remaining) — O(m*n*k) time, O(m*n*k) space
// Solution: BFS with State — O(m*n*k) time, O(m*n*k) space
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 2) return m + n - 2;
        boolean[][][] visited = new boolean[m][n][k+1];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            steps++;
            for (int sz = q.size(); sz > 0; sz--) {
                int[] cur = q.poll();
                int r=cur[0], c=cur[1], rem=cur[2];
                for (int[] d : dirs) {
                    int nr=r+d[0], nc=c+d[1];
                    if (nr<0||nr>=m||nc<0||nc>=n) continue;
                    int nrem = rem - grid[nr][nc];
                    if (nrem < 0 || visited[nr][nc][nrem]) continue;
                    if (nr==m-1 && nc==n-1) return steps;
                    visited[nr][nc][nrem] = true;
                    q.add(new int[]{nr, nc, nrem});
                }
            }
        }
        return -1;
    }
}
