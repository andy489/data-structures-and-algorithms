// https://leetcode.com/problems/minimum-falling-path-sum/

// Solution: DP In-Place — O(n²) time, O(1) space
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int best = matrix[i - 1][j];
                if (j > 0) {
                    best = Math.min(best, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    best = Math.min(best, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += best;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : matrix[n - 1]) {
            min = Math.min(min, x);
        }
        return min;
    }
}
