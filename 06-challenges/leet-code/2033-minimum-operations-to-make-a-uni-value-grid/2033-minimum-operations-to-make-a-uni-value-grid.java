// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

// Solution: Flatten, Sort, Median — O(mn log mn) time, O(mn) space
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] vals = new int[m * n];
        int idx = 0;
        for (int[] row : grid) { for (int v : row) { vals[idx++] = v; } }
        Arrays.sort(vals);
        int rem = vals[0] % x;
        for (int v : vals) { if (v % x != rem) { return -1; } }
        int median = vals[vals.length / 2];
        int ops = 0;
        for (int v : vals) { ops += Math.abs(v - median) / x; }
        return ops;
    }
}
