// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

// Solution: Binary Search — O(log(maxSum)) time, O(1) space
class Solution {
    private long sumSide(long v, long len) {
        if (v >= len) {
            long lo = v - len + 1;
            return (v + lo) * len / 2;
        } else {
            return v * (v + 1) / 2 + (len - v);
        }
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = index, right = n - 1 - index;
        int lo = 1, hi = maxSum;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            long total = sumSide(mid, left + 1) + sumSide(mid, right + 1) - mid;
            if (total <= maxSum) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
