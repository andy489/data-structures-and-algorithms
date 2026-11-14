// https://leetcode.com/problems/spiral-matrix-ii/

// Solution: Layer-by-Layer Boundary Shrink — O(n²) time, O(1) extra space
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, num = 1;
        while (num <= n * n) {
            for (int c = left; c <= right; c++) matrix[top][c] = num++;
            top++;
            for (int r = top; r <= bottom; r++) matrix[r][right] = num++;
            right--;
            for (int c = right; c >= left; c--) matrix[bottom][c] = num++;
            bottom--;
            for (int r = bottom; r >= top; r--) matrix[r][left] = num++;
            left++;
        }
        return matrix;
    }
}
