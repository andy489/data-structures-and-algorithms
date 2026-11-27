// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

// Solution: DP + Binary Search — O(n log n) time, O(n) space
// Solution: DP + Binary Search — O(n log n) time, O(n) space
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) jobs[i] = new int[]{endTime[i], startTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (jobs[mid-1][0] <= jobs[i][1]) lo = mid; else hi = mid - 1;
            }
            dp[i+1] = Math.max(dp[i], dp[lo] + jobs[i][2]);
        }
        return dp[n];
    }
}
