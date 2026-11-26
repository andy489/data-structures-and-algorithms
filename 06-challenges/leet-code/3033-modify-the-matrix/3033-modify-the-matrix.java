// https://leetcode.com/problems/modify-the-matrix/

// Solution: Column Max — O(m*n) time, O(1) space
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            int colMax = -1;
            for (int i = 0; i < m; i++) {
                colMax = Math.max(colMax, matrix[i][j]);
            }
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == -1) { matrix[i][j] = colMax; }
            }
        }
        return matrix;
    }
}
