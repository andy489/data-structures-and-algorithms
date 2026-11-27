// https://leetcode.com/problems/maximize-the-minimum-game-score/
class Solution {
    public long maxScore(int[] points, int m) {
        long lo = 0, hi = (long) (m + 1) * 1000000L;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (canAchieve(points, m, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canAchieve(int[] points, long m, long minScore) {
        long moves = m;
        for (int i = 0; i < points.length; i++) {
            long needed = (minScore + points[i] - 1) / points[i];
            moves -= 2 * needed - 1;
            if (moves < 0) {
                return false;
            }
        }
        return true;
    }
}
