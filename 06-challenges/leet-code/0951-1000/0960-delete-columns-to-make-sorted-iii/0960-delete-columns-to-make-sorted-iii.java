// https://leetcode.com/problems/delete-columns-to-make-sorted-iii/

// Solution: LIS on Columns — O(m²n) time, O(m) space
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int[] dp = new int[m];
        java.util.Arrays.fill(dp, 1);
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < j; i++) {
                boolean valid = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int maxKeep = 0;
        for (int x : dp) { maxKeep = Math.max(maxKeep, x); }
        return m - maxKeep;
    }
}
