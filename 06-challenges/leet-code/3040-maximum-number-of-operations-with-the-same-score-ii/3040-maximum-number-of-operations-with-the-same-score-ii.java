// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/

// Solution: DP with Memoization — O(n²) time, O(n²) space
class Solution {
    private int[] nums;
    private int[][] memo;
    private int target;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int ans = 1;
        int[] targets = {nums[0]+nums[1], nums[n-1]+nums[n-2], nums[0]+nums[n-1]};
        for (int t : targets) {
            this.target = t;
            this.memo = new int[n][n];
            for (int[] row : memo) { java.util.Arrays.fill(row, -1); }
            ans = Math.max(ans, dp(0, n - 1));
        }
        return ans;
    }

    private int dp(int l, int r) {
        if (r - l < 1) { return 0; }
        if (memo[l][r] != -1) { return memo[l][r]; }
        int res = 0;
        if (nums[l] + nums[l+1] == target) { res = Math.max(res, 1 + dp(l+2, r)); }
        if (nums[r-1] + nums[r] == target) { res = Math.max(res, 1 + dp(l, r-2)); }
        if (nums[l] + nums[r] == target) { res = Math.max(res, 1 + dp(l+1, r-1)); }
        return memo[l][r] = res;
    }
}
