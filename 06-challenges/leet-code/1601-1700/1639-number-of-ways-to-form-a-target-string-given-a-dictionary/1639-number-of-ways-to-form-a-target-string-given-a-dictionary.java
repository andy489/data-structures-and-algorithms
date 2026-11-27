// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

// Solution: DP with Precomputed Column Frequencies — O(L * m) time, O(26 * L + m) space
class Solution {
    public int numWays(String[] words, String target) {
        final int MOD = 1_000_000_007;
        int L = words[0].length(), m = target.length();
        int[][] cnt = new int[L][26];
        for (String w : words) {
            for (int k = 0; k < L; k++) {
                cnt[k][w.charAt(k) - 'a']++;
            }
        }
        long[] dp = new long[m + 1];
        dp[0] = 1;
        for (int k = 0; k < L; k++) {
            for (int i = Math.min(k, m - 1); i >= 0; i--) {
                int c = target.charAt(i) - 'a';
                dp[i + 1] = (dp[i + 1] + dp[i] * cnt[k][c]) % MOD;
            }
        }
        return (int) dp[m];
    }
}
