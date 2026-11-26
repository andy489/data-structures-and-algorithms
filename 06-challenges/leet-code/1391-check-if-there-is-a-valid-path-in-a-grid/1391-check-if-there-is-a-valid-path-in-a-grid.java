// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

// Solution: BFS — O(m*n) time, O(m*n) space
class Solution {
    // street[i] = {up,down,left,right} connectivity for street type i+1
    static int[][] streets = {
        {0,0,1,1}, // 1: left-right
        {1,1,0,0}, // 2: up-down
        {0,1,1,0}, // 3: left-down
        {0,1,0,1}, // 4: right-down
        {1,0,0,1}, // 5: right-up
        {1,0,1,0}  // 6: left-up
    };
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[] opposite = {1,0,3,2};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == m-1 && c == n-1) return true;
            for (int d = 0; d < 4; d++) {
                int nr = r+dirs[d][0], nc = c+dirs[d][1];
                if (nr<0||nr>=m||nc<0||nc>=n) continue;
                if (visited[nr][nc]) continue;
                int st = grid[r][c]-1, nst = grid[nr][nc]-1;
                if (streets[st][d]==1 && streets[nst][opposite[d]]==1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return false;
    }
}
