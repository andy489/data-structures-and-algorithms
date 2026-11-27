// https://leetcode.com/problems/making-a-large-island/

// Solution: Island Labeling + DFS — O(n²) time, O(n²) space
class Solution {
    private int n;
    private int[][] grid;
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int id = 2, max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(r, c, id);
                    islandSize.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int size = 1;
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > 1) {
                            seen.add(grid[nr][nc]);
                        }
                    }
                    for (int islandId : seen) {
                        size += islandSize.get(islandId);
                    }
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int id) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = id;
        int size = 1;
        for (int[] d : dirs) {
            size += dfs(r + d[0], c + d[1], id);
        }
        return size;
    }
}
