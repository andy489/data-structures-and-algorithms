// https://leetcode.com/problems/where-will-the-ball-fall/

// Solution: Simulation — O(m * n) time, O(n) space
class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            int col = j;
            for (int row = 0; row < m; row++) {
                int dir = grid[row][col];
                int next = col + dir;
                if (next < 0 || next >= n || grid[row][next] != dir) {
                    col = -1;
                    break;
                }
                col = next;
            }
            result[j] = col;
        }
        return result;
    }
}
