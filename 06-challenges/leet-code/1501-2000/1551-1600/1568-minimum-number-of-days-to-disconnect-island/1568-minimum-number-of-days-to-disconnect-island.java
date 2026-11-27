// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

// Solution: Articulation Points — O(m * n) time, O(m * n) space
class Solution {
    private int[][] grid;
    private int m, n;
    private int[] disc, low;
    private int timer;
    private boolean hasAP;

    public int minDays(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int islands = countIslands();
        if (islands != 1) {
            return 0;
        }

        // Check if removing any single cell disconnects
        disc = new int[m * n];
        low = new int[m * n];
        java.util.Arrays.fill(disc, -1);
        timer = 0;
        hasAP = false;
        int landCount = 0;
        int startId = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    landCount++;
                    startId = i * n + j;
                }
            }
        }
        if (landCount == 1) {
            return 1;
        }
        int si = startId / n, sj = startId % n;
        dfs(si, sj, -1);
        return hasAP ? 1 : 2;
    }

    private int countIslands() {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    flood(visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void flood(boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1 && !vis[ni][nj]) {
                flood(vis, ni, nj);
            }
        }
    }

    private void dfs(int i, int j, int parentId) {
        int id = i * n + j;
        disc[id] = low[id] = timer++;
        int children = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] == 0) {
                continue;
            }
            int nid = ni * n + nj;
            if (disc[nid] == -1) {
                children++;
                dfs(ni, nj, id);
                low[id] = Math.min(low[id], low[nid]);
                if (parentId == -1 && children > 1) {
                    hasAP = true;
                }
                if (parentId != -1 && low[nid] >= disc[id]) {
                    hasAP = true;
                }
            } else if (nid != parentId) {
                low[id] = Math.min(low[id], disc[nid]);
            }
        }
    }
}
