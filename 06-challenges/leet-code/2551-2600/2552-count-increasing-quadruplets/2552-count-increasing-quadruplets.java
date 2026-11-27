// https://leetcode.com/problems/count-increasing-quadruplets/

// Solution: O(n²) DP — count valid (i,j,k) triples then multiply by suffix count
class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long ans = 0;
        // dp[j] = number of valid (i, k, j) triples where nums[i] < nums[k] < nums[j]
        // i.e., j plays role of the "l" position, k is the pivot
        // We track: for each j, how many k<j have nums[k] < nums[j] and
        // some i<k with nums[i] < nums[k]
        long[] dp = new long[n];
        for (int k = 0; k < n; k++) {
            long cntLess = 0; // count of i < k with nums[i] < nums[k]
            for (int i = 0; i < k; i++) {
                if (nums[i] < nums[k]) {
                    cntLess++;
                }
            }
            // For each j > k with nums[j] > nums[k], this k contributes to dp[j]
            for (int j = k + 1; j < n; j++) {
                if (nums[j] > nums[k]) {
                    ans += dp[j];  // dp[j] = valid triples ending at j as 'l'
                    // But wait: dp[j] should count (i,k,j) triples where nums[i]<nums[k]<nums[j]
                }
            }
            // Update dp: for each j > k with nums[j] > nums[k],
            // dp[j] += cntLess (number of i < k with nums[i] < nums[k])
            for (int j = k + 1; j < n; j++) {
                if (nums[j] > nums[k]) {
                    dp[j] += cntLess;
                }
            }
        }
        return ans;
    }
}
