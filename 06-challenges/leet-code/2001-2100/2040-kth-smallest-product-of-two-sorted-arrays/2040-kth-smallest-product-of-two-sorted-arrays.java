// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

// Solution: Binary Search on Answer — O((m+n) log MaxVal) time, O(1) space
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = -((long)1e10), hi = (long)1e10;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (count(nums1, nums2, mid) >= k) { hi = mid; }
            else { lo = mid + 1; }
        }
        return lo;
    }
    private long count(int[] a, int[] b, long v) {
        long cnt = 0;
        int m = b.length;
        for (int x : a) {
            if (x > 0) {
                // x * b[j] <= v => b[j] <= v/x
                int pos = upperBound(b, v / x);
                if (v < 0 && v % x != 0) { pos = upperBound(b, v / x - 1); }
                cnt += pos;
            } else if (x < 0) {
                // x * b[j] <= v => b[j] >= ceil(v/x)
                long threshold = v / x;
                if (v > 0 || (v < 0 && v % x != 0)) { threshold = v / x + (v % x != 0 ? 1 : 0); }
                int pos = lowerBound(b, threshold);
                cnt += m - pos;
            } else {
                if (v >= 0) { cnt += m; }
            }
        }
        return cnt;
    }
    private int upperBound(int[] b, long val) {
        int lo = 0, hi = b.length;
        while (lo < hi) { int mid = (lo + hi) / 2; if (b[mid] <= val) { lo = mid + 1; } else { hi = mid; } }
        return lo;
    }
    private int lowerBound(int[] b, long val) {
        int lo = 0, hi = b.length;
        while (lo < hi) { int mid = (lo + hi) / 2; if (b[mid] < val) { lo = mid + 1; } else { hi = mid; } }
        return lo;
    }
}
