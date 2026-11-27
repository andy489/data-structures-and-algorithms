// https://leetcode.com/problems/shortest-bridge/

// Solution: DFS + BFS — O(n²) time, O(n²) space
class Solution {
    int n;
    int[][] grid;
    int[] qr, qc;
    int head, tail;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        qr = new int[n * n];
        qc = new int[n * n];
        head = tail = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    break outer;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int steps = 0;
        while (head < tail) {
            int size = tail - head;
            while (size-- > 0) {
                int r = qr[head], c = qc[head++];
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        return steps;
                    }
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        qr[tail] = nr;
                        qc[tail++] = nc;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        qr[tail] = r;
        qc[tail++] = c;
        dfs(r+1, c); dfs(r-1, c); dfs(r, c+1); dfs(r, c-1);
    }
}
