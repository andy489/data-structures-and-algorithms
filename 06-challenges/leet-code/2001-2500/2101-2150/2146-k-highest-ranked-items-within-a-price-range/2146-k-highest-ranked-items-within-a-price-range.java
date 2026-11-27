// https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];

        List<int[]> candidates = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];
            int price = grid[r][c];

            if (price >= low && price <= high) {
                candidates.add(new int[]{dist, price, r, c});
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        candidates.sort((a, b) -> {
            if (a[0] != b[0]) { return a[0] - b[0]; }
            if (a[1] != b[1]) { return a[1] - b[1]; }
            if (a[2] != b[2]) { return a[2] - b[2]; }
            return a[3] - b[3];
        });

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, candidates.size()); i++) {
            int[] item = candidates.get(i);
            result.add(Arrays.asList(item[2], item[3]));
        }
        return result;
    }
}
