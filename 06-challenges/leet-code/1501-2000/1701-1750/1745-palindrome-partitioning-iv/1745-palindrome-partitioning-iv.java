// https://leetcode.com/problems/palindrome-partitioning-iv/

// Solution: DP Palindrome Table — O(n²) time, O(n²) space
class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (isPalin[0][i - 1] && isPalin[i][j] && isPalin[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
