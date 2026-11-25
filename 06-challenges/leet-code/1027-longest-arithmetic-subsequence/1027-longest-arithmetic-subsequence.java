// https://leetcode.com/problems/longest-arithmetic-subsequence/

// Solution: DP with Hash Map — O(n²) time, O(n²) space
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].merge(diff, len, Math::max);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
