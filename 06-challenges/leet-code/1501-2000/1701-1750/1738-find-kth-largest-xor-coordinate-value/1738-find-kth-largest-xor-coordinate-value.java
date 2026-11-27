// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

// Solution: 2D XOR Prefix + Sort — O(m·n·log(m·n)) time, O(m·n) space
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] ^= matrix[i][j - 1];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                matrix[i][j] ^= matrix[i - 1][j];
            }
        }
        int[] vals = new int[m * n];
        int idx = 0;
        for (int[] row : matrix) {
            for (int v : row) {
                vals[idx++] = v;
            }
        }
        Arrays.sort(vals);
        return vals[m * n - k];
    }
}
