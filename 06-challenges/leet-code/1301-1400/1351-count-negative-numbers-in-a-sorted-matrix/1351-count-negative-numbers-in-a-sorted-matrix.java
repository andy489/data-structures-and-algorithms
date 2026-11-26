// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

// Solution: Two-pointer — O(m+n) time, O(1) space
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (grid[i][j] < 0) { count += m - i; j--; }
            else { i++; }
        }
        return count;
    }
}
