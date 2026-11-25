// https://leetcode.com/problems/surface-area-of-3d-shapes/

// Solution: Direct Calculation — O(n^2) time, O(1) space
class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    ans += 4 * grid[i][j] + 2;
                }
                if (i > 0) { ans -= 2 * Math.min(grid[i][j], grid[i-1][j]); }
                if (j > 0) { ans -= 2 * Math.min(grid[i][j], grid[i][j-1]); }
            }
        }
        return ans;
    }
}
