// https://leetcode.com/problems/rotate-image/

// Solution: Transpose + reverse rows — O(n²) time, O(1) space
// 90° clockwise = transpose (swap across main diagonal) then reverse each row.
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose: matrix[i][j] ↔ matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}

// Solution2: Layer-by-layer 4-way cycle — O(n²) time, O(1) space
// Rotate elements ring by ring; within each ring move four cells at once.
class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];
                matrix[layer][i]           = matrix[last - offset][layer]; // left → top
                matrix[last - offset][layer] = matrix[last][last - offset]; // bottom → left
                matrix[last][last - offset] = matrix[i][last];             // right → bottom
                matrix[i][last]             = top;                         // top → right
            }
        }
    }
}
