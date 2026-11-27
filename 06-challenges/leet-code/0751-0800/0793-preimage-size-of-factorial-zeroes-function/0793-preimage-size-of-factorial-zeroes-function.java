// https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/

// Solution: Binary Search — O(log² k) time, O(1) space
class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (leftBound(k) - leftBound(k - 1));
    }

    private long leftBound(int k) {
        long lo = 0, hi = 5L * (k + 1);
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) <= k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private long trailingZeroes(long x) {
        long count = 0;
        while (x >= 5) {
            x /= 5;
            count += x;
        }
        return count;
    }
}
