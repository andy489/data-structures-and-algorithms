// https://leetcode.com/problems/count-number-of-special-subsequences/
class Solution {
    public int countSpecialSubsequences(int[] nums) {
        final int MOD = 1_000_000_007;
        long dp0 = 0, dp1 = 0, dp2 = 0;
        for (int num : nums) {
            if (num == 0) {
                dp0 = (2 * dp0 + 1) % MOD;
            } else if (num == 1) {
                dp1 = (2 * dp1 + dp0) % MOD;
            } else {
                dp2 = (2 * dp2 + dp1) % MOD;
            }
        }
        return (int) dp2;
    }
}
