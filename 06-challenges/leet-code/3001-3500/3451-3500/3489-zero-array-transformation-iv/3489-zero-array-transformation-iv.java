// https://leetcode.com/problems/zero-array-transformation-iv/

// Solution: Binary Search + DP Subset Sum — O(q * n * V) time, O(n * V) space
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        int lo = 0, hi = q, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canZero(nums, queries, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            boolean[] dp = new boolean[nums[i] + 1];
            dp[0] = true;
            for (int j = 0; j < k; j++) {
                int l = queries[j][0], r = queries[j][1], val = queries[j][2];
                if (l <= i && i <= r) {
                    // Update dp in reverse
                    for (int s = nums[i]; s >= val; s--) {
                        if (dp[s - val]) {
                            dp[s] = true;
                        }
                    }
                }
            }
            if (!dp[nums[i]]) {
                return false;
            }
        }
        return true;
    }
}
