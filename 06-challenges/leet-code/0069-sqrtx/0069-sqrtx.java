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

// Solution 2: Newton's Method, integer — O(log log x) time, O(1) space
// Implicit epsilon = 1: stop when r*r <= x (r can't get closer than 1 in integer arithmetic)
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

// Solution 3: Newton's Method, floating-point with explicit epsilon — O(log log(x/eps)) time, O(1) space
// General version: stop when |r*r - x| < eps.
// eps = 1e-5 gives 5 decimal places of precision; each extra decimal place costs ~1 iteration.
class Solution3 {
    public double mySqrt(double x, double eps) {
        if (x == 0) {
            return 0;
        }
        double r = x;
        while (Math.abs(r * r - x) > eps) {
            r = (r + x / r) / 2.0;
        }
        return r;
    }
}
