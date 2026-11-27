// https://leetcode.com/problems/shift-2d-grid/

// Solution: Index Mapping — O(m*n) time, O(m*n) space
// Solution: Index Mapping — O(m*n) time, O(m*n) space
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, total = m * n;
        int[] flat = new int[total];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) flat[i * n + j] = grid[i][j];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) row.add(flat[((i * n + j) - k % total + total) % total]);
            res.add(row);
        }
        return res;
    }
}
