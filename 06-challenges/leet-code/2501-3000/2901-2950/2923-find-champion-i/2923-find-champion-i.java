// https://leetcode.com/problems/find-champion-i/

// Solution: Count In-Degrees — O(n²) time, O(1) space
class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int wins = 0;
            for (int j = 0; j < n; j++) {
                wins += grid[i][j];
            }
            if (wins == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
