// https://leetcode.com/problems/sqrtx/

// Solution 1: Binary Search — O(log x) time, O(1) space
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

// Solution 2: Newton's Method (Babylonian method, ~2000 BCE) — O(log log x) time, O(1) space
// r_next = (r + x/r) / 2  converges quadratically; AM-GM guarantees r >= sqrt(x) always
class Solution2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
