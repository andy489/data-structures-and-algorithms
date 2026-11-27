// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// Solution: Binary Search — O(n log(sum)) time, O(1) space
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canShip(weights, days, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int daysNeeded = 1, cur = 0;
        for (int w : weights) {
            if (cur + w > cap) {
                daysNeeded++;
                cur = 0;
            }
            cur += w;
        }
        return daysNeeded <= days;
    }
}
