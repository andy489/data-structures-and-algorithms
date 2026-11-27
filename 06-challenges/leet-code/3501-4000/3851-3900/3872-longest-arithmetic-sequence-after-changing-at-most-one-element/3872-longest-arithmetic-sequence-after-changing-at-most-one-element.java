// https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/

class Solution {
    public int longestArithSeqAfterChange(int[] nums) {
        int n = nums.length;
        int[] dp0 = new int[n]; // no changes
        int[] dp1 = new int[n]; // at most one change
        dp0[0] = dp1[0] = 1;
        dp0[1] = dp1[1] = 2;
        int ans = 2;
        for (int i = 2; i < n; i++) {
            int d1 = nums[i] - nums[i - 1];
            int d2 = nums[i - 1] - nums[i - 2];
            if (d1 == d2) {
                dp0[i] = dp0[i - 1] + 1;
                dp1[i] = dp1[i - 1] + 1;
            } else {
                dp0[i] = 2;
                // change nums[i] to fit into previous arithmetic seq ending at i-1 with 0 changes
                dp1[i] = dp0[i - 1] + 1;
                // change nums[i-1] to fit: need nums[i] - nums[i-2] == 2 * d2 or fit from dp0[i-2]
                // if d3 / 2 == d2, then nums[i-1] = nums[i-2] + d2 works as a replacement
                int d3 = nums[i] - nums[i - 2];
                if (d3 % 2 == 0 && d3 / 2 == d2) {
                    dp1[i] = Math.max(dp1[i], dp0[i - 2] + 2);
                }
            }
            ans = Math.max(ans, Math.max(dp0[i], dp1[i]));
        }
        return ans;
    }
}
