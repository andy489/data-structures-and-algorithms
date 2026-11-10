// https://leetcode.com/problems/sqrtx/

// Solution: Binary Search — O(log x) time, O(1) space
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int lo = 1, hi = x / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sq = (long) mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
}
