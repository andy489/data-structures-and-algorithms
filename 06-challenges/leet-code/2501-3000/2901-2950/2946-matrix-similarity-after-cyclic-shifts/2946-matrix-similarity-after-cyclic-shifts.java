// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

// Solution: Check Net Shift — O(m*n) time, O(1) extra space
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int shift = k % n;
        if (shift == 0) {
            return true;
        }
        for (int[] row : mat) {
            for (int j = 1; j < n; j++) {
                if (row[j] != row[0]) {
                    return false;
                }
            }
        }
        return true;
    }
}
