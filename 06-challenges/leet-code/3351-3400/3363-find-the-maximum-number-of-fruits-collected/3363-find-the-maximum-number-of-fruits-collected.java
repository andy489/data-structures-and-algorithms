// https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/

// Solution: Independent DP for Each Side Child — O(n^2) time, O(n^2) space
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        final int NEG_INF = Integer.MIN_VALUE / 2;

        // Child 1: forced diagonal (0,0) -> (n-1,n-1)
        long diag = 0;
        for (int i = 0; i < n; i++) {
            diag += fruits[i][i];
        }

        // Child 2: (0,n-1) -> (n-1,n-1), moves: down-left, down, down-right
        // dp2[i][j] = max fruits for child 2 reaching row i at column j
        // Avoid diagonal cells (they belong to child 1)
        long[][] dp2 = new long[n][n];
        for (long[] row : dp2) {
            java.util.Arrays.fill(row, NEG_INF);
        }
        dp2[0][n - 1] = fruits[0][n - 1];  // start cell (not on diagonal for n >= 2)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue; // diagonal belongs to child 1
                }
                long best = NEG_INF;
                if (j - 1 >= 0 && dp2[i - 1][j - 1] != NEG_INF) {
                    best = Math.max(best, dp2[i - 1][j - 1]);
                }
                if (dp2[i - 1][j] != NEG_INF) {
                    best = Math.max(best, dp2[i - 1][j]);
                }
                if (j + 1 < n && dp2[i - 1][j + 1] != NEG_INF) {
                    best = Math.max(best, dp2[i - 1][j + 1]);
                }
                if (best != NEG_INF) {
                    dp2[i][j] = best + fruits[i][j];
                }
            }
        }
        long child2 = dp2[n - 1][n - 1];

        // Child 3: (n-1,0) -> (n-1,n-1), moves: up-right, right, down-right
        // dp3[i][j] = max fruits for child 3 reaching column j at row i
        // Avoid diagonal cells
        long[][] dp3 = new long[n][n];
        for (long[] row : dp3) {
            java.util.Arrays.fill(row, NEG_INF);
        }
        dp3[n - 1][0] = fruits[n - 1][0];  // start cell (not on diagonal for n >= 2)
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i == j) {
                    continue; // diagonal belongs to child 1
                }
                long best = NEG_INF;
                if (i - 1 >= 0 && dp3[i - 1][j - 1] != NEG_INF) {
                    best = Math.max(best, dp3[i - 1][j - 1]);
                }
                if (dp3[i][j - 1] != NEG_INF) {
                    best = Math.max(best, dp3[i][j - 1]);
                }
                if (i + 1 < n && dp3[i + 1][j - 1] != NEG_INF) {
                    best = Math.max(best, dp3[i + 1][j - 1]);
                }
                if (best != NEG_INF) {
                    dp3[i][j] = best + fruits[i][j];
                }
            }
        }
        long child3 = dp3[n - 1][n - 1];

        return (int) (diag + child2 + child3);
    }
}
