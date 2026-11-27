// https://leetcode.com/problems/greatest-sum-divisible-by-three/

// Solution: Dynamic Programming — O(n) time, O(1) space
// Solution: Dynamic Programming — O(n) time, O(1) space
class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int x : nums) {
            int[] ndp = dp.clone();
            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) ndp[(r + x) % 3] = Math.max(ndp[(r + x) % 3], dp[r] + x);
            }
            dp = ndp;
        }
        return dp[0];
    }
}
