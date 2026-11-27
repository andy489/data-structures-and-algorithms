// https://leetcode.com/problems/contain-virus/

// Solution: Simulation with BFS — O((mn)²) time, O(mn) space
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalWalls = 0;
        while (true) {
            List<List<int[]>> regions = new ArrayList<>();
            List<Set<Integer>> threats = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        List<int[]> region = new ArrayList<>();
                        Set<Integer> threat = new HashSet<>();
                        int[] wallCount = {0};
                        bfs(grid, visited, i, j, region, threat, wallCount);
                        if (!threat.isEmpty()) {
                            regions.add(region);
                            threats.add(threat);
                            walls.add(wallCount[0]);
                        }
                    }
                }
            }
            if (regions.isEmpty()) {
                break;
            }
            int worstIdx = 0;
            for (int i = 1; i < threats.size(); i++) {
                if (threats.get(i).size() > threats.get(worstIdx).size()) {
                    worstIdx = i;
                }
            }
            totalWalls += walls.get(worstIdx);
            for (int[] cell : regions.get(worstIdx)) {
                grid[cell[0]][cell[1]] = -1;
            }
            for (int i = 0; i < regions.size(); i++) {
                if (i != worstIdx) {
                    for (int[] cell : regions.get(i)) {
                        for (int[] d : dirs) {
                            int ni = cell[0] + d[0], nj = cell[1] + d[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 0) {
                                grid[ni][nj] = 1;
                            }
                        }
                    }
                }
            }
        }
        return totalWalls;
    }

    private void bfs(int[][] grid, boolean[][] visited, int si, int sj,
                     List<int[]> region, Set<Integer> threat, int[] wallCount) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{si, sj});
        visited[si][sj] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            region.add(new int[]{r, c});
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                } else if (grid[nr][nc] == 0) {
                    threat.add(nr * n + nc);
                    wallCount[0]++;
                }
            }
        }
    }
}
