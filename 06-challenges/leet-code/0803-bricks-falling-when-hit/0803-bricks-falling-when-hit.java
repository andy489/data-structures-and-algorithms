// https://leetcode.com/problems/bricks-falling-when-hit/

// Solution: Reverse Union-Find — O(hits·α(mn)) time, O(mn) space
class Solution {
    private int[] parent, size;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = grid[i].clone();
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        parent = new int[m * n + 1];
        size = new int[m * n + 1];
        for (int i = 0; i <= m * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int roof = m * n;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (copy[r][c] == 1) {
                    if (r == 0) {
                        union(r * n + c, roof);
                    }
                    if (r > 0 && copy[r - 1][c] == 1) {
                        union(r * n + c, (r - 1) * n + c);
                    }
                    if (c > 0 && copy[r][c - 1] == 1) {
                        union(r * n + c, r * n + c - 1);
                    }
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 0) {
                continue;
            }
            int prevRoof = size[find(roof)];
            copy[r][c] = 1;
            if (r == 0) {
                union(r * n + c, roof);
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && copy[nr][nc] == 1) {
                    union(r * n + c, nr * n + nc);
                }
            }
            int newRoof = size[find(roof)];
            result[i] = Math.max(0, newRoof - prevRoof - 1);
        }
        return result;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) {
            return;
        }
        if (size[px] < size[py]) {
            int tmp = px;
            px = py;
            py = tmp;
        }
        parent[py] = px;
        size[px] += size[py];
    }
}
