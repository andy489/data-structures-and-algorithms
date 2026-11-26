// https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/

// Solution: DP with XOR Grouping — O(k * 2^10) time, O(2^10) space
class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 1 << 10;
        int[] dp = new int[maxVal];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int j = 0; j < k; j++) {
            // Build frequency map for group j
            int[] cnt = new int[maxVal];
            int sz = 0;
            for (int i = j; i < n; i += k) {
                cnt[nums[i]]++;
                sz++;
            }
            // Global min of current dp
            int globalMin = Integer.MAX_VALUE / 2;
            for (int x = 0; x < maxVal; x++) {
                globalMin = Math.min(globalMin, dp[x]);
            }
            int[] ndp = new int[maxVal];
            Arrays.fill(ndp, globalMin + sz); // change all elements in this group
            for (int x = 0; x < maxVal; x++) {
                if (dp[x] >= Integer.MAX_VALUE / 2) {
                    continue;
                }
                for (int v = 0; v < maxVal; v++) {
                    if (cnt[v] == 0) {
                        continue;
                    }
                    int newXor = x ^ v;
                    int cost = dp[x] + sz - cnt[v];
                    ndp[newXor] = Math.min(ndp[newXor], cost);
                }
            }
            dp = ndp;
        }
        return dp[0];
    }
}
