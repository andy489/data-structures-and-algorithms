// https://leetcode.com/problems/parallel-courses-ii/

// Solution: Bitmask DP — O(3^n) time, O(2^n) space
class Solution {
    public int minNumberOfSemesters(int n, int[][] deps, int k) {
        int[] pre = new int[n];
        for (int[] d : deps) pre[d[1]-1] |= 1 << (d[0]-1);
        int[] dp = new int[1<<n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1<<n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            int avail = 0;
            for (int i = 0; i < n; i++)
                if ((mask & (1<<i)) == 0 && (mask & pre[i]) == pre[i]) avail |= (1<<i);
            for (int sub = avail; sub > 0; sub = (sub-1) & avail) {
                if (Integer.bitCount(sub) <= k)
                    dp[mask|sub] = Math.min(dp[mask|sub], dp[mask]+1);
            }
        }
        return dp[(1<<n)-1];
    }
}
