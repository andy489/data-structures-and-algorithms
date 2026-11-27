// https://leetcode.com/problems/maximum-running-time-of-n-computers/
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalSum = 0;
        for (int b : batteries) {
            totalSum += b;
        }
        long lo = 0, hi = totalSum / n;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (canRun(n, batteries, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canRun(int n, int[] batteries, long t) {
        long extra = 0;
        int large = 0;
        for (int b : batteries) {
            if (b >= t) {
                large++;
            } else {
                extra += b;
            }
        }
        if (large >= n) {
            return true;
        }
        // Remaining n - large computers need extra pool
        return extra >= (long)(n - large) * t;
    }
}
