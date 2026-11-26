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

// Solution 2: Recursion — O(n²) time, O(n) space
class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fill(matrix, 0, n, 1);
        return matrix;
    }

    private void fill(int[][] matrix, int offset, int n, int num) {
        if (n == 0) return;
        if (n == 1) { matrix[offset][offset] = num; return; }
        for (int c = offset; c < offset + n - 1; c++) matrix[offset][c] = num++;
        for (int r = offset; r < offset + n - 1; r++) matrix[r][offset + n - 1] = num++;
        for (int c = offset + n - 1; c > offset; c--) matrix[offset + n - 1][c] = num++;
        for (int r = offset + n - 1; r > offset; r--) matrix[r][offset] = num++;
        fill(matrix, offset + 1, n - 2, num);
    }
}
