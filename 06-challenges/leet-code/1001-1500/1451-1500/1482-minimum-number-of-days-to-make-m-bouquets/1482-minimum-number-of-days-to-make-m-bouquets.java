// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

// Solution: Binary Search — O(n log maxDay) time, O(1) space
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * k;
        if (total > bloomDay.length) return -1;
        int lo = 1, hi = 0;
        for (int d : bloomDay) hi = Math.max(hi, d);
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canMake(bloomDay, m, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private boolean canMake(int[] bd, int m, int k, int day) {
        int bouquets = 0, consecutive = 0;
        for (int d : bd) {
            if (d <= day) { consecutive++; if (consecutive == k) { bouquets++; consecutive = 0; } }
            else consecutive = 0;
        }
        return bouquets >= m;
    }
}
