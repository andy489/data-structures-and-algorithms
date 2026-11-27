// https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
class Solution {
    public long minimumPerimeter(long neededApples) {
        long lo = 1, hi = 100000;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return 8 * lo;
    }
}
