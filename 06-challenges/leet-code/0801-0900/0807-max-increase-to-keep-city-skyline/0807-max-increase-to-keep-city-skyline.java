// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

// Solution: Row/Column Maxima — O(n²) time, O(n) space
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n], colMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return total;
    }
}
