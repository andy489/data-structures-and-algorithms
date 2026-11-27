// https://leetcode.com/problems/palindrome-partitioning-ii/

// Solution 1: DP + Expand-Around-Center — O(n²) time, O(n) space
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) cut[i] = i;
        for (int c = 0; c < n; c++) {
            // odd-length palindromes
            for (int k = 0; c - k >= 0 && c + k < n && s.charAt(c - k) == s.charAt(c + k); k++) {
                int left = c - k, right = c + k;
                cut[right] = left == 0 ? 0 : Math.min(cut[right], cut[left - 1] + 1);
            }
            // even-length palindromes
            for (int k = 1; c - k + 1 >= 0 && c + k < n && s.charAt(c - k + 1) == s.charAt(c + k); k++) {
                int left = c - k + 1, right = c + k;
                cut[right] = left == 0 ? 0 : Math.min(cut[right], cut[left - 1] + 1);
            }
        }
        return cut[n - 1];
    }
}

// Solution 2: DP + 2-D Palindrome Table — O(n²) time, O(n²) space
class Solution2 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalin[i][i] = true;
        for (int i = 0; i < n - 1; i++) isPalin[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                isPalin[i][j] = (s.charAt(i) == s.charAt(j)) && isPalin[i + 1][j - 1];
            }
        }
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalin[0][i]) { cut[i] = 0; continue; }
            cut[i] = i;
            for (int j = 1; j <= i; j++) {
                if (isPalin[j][i]) cut[i] = Math.min(cut[i], cut[j - 1] + 1);
            }
        }
        return cut[n - 1];
    }
}
