// https://leetcode.com/problems/check-knight-tour-configuration/
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[] rows = new int[n * n];
        int[] cols = new int[n * n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rows[grid[r][c]] = r;
                cols[grid[r][c]] = c;
            }
        }
        for (int m = 0; m < n * n - 1; m++) {
            int dr = Math.abs(rows[m + 1] - rows[m]);
            int dc = Math.abs(cols[m + 1] - cols[m]);
            if (!((dr == 1 && dc == 2) || (dr == 2 && dc == 1))) {
                return false;
            }
        }
        return true;
    }
}
