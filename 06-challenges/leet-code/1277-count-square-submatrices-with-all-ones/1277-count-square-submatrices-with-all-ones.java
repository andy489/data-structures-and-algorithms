// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

// Solution: Dynamic Programming — O(m*n) time, O(1) — in-place space
// Solution: Dynamic Programming (in-place) — O(m*n) time, O(1) space
class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
