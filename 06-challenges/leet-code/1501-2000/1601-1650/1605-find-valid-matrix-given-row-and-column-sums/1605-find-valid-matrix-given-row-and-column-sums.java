// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

// Solution: Greedy — O(m*n) time, O(m*n) space
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = val;
                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }
        return matrix;
    }
}
