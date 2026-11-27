// https://leetcode.com/problems/maximal-square/

// Solution: 2D DP — O(m·n) time, O(m·n) space
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0 || j == 0) ? 1
                        : Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}

// Solution 2: O(n) Space DP — O(m·n) time, O(n) space
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int maxSide = 0, prev = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                if (matrix[i][j] == '1') {
                    dp[j] = (i == 0 || j == 0) ? 1
                        : Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSide * maxSide;
    }
}
