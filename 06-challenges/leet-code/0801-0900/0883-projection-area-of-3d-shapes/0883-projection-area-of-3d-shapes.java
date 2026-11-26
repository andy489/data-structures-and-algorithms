// https://leetcode.com/problems/projection-area-of-3d-shapes/

// Solution: Direct Calculation — O(n^2) time, O(1) space
class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, xy = 0, yz = 0, zx = 0;
        for (int i = 0; i < n; i++) {
            int rowMax = 0, colMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) { xy++; }
                rowMax = Math.max(rowMax, grid[i][j]);
                colMax = Math.max(colMax, grid[j][i]);
            }
            yz += rowMax;
            zx += colMax;
        }
        return xy + yz + zx;
    }
}
