// https://leetcode.com/problems/island-perimeter/

// Solution: Count Shared Edges — O(m·n) time, O(1) space
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    perimeter += 4;
                    if (c + 1 < cols && grid[r][c + 1] == 1) {
                        perimeter -= 2;
                    }
                    if (r + 1 < rows && grid[r + 1][c] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }
}
