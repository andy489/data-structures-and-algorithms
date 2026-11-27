// https://leetcode.com/problems/minimum-time-to-repair-cars/
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minRank = ranks[0];
        for (int r : ranks) {
            if (r < minRank) {
                minRank = r;
            }
        }
        long lo = 1, hi = minRank * (long) cars * cars;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canFinish(ranks, cars, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canFinish(int[] ranks, int cars, long time) {
        long total = 0;
        for (int r : ranks) {
            total += (long) Math.sqrt((double) time / r);
            if (total >= cars) {
                return true;
            }
        }
        return total >= cars;
    }
}
