// https://leetcode.com/problems/super-ugly-number/

// Solution: DP with k Pointers — O(n*k) time, O(n+k) space
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] dp = new int[n];
        int[] ptrs = new int[k];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                minVal = Math.min(minVal, dp[ptrs[j]] * primes[j]);
            }
            dp[i] = minVal;
            for (int j = 0; j < k; j++) {
                if (dp[ptrs[j]] * primes[j] == minVal) {
                    ptrs[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
