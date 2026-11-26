// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

// Solution: Binary Search — O(m log maxQ) time, O(1) space
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1, hi = 0;
        for (int q : quantities) { hi = Math.max(hi, q); }
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canDistribute(quantities, n, mid)) { hi = mid; }
            else { lo = mid + 1; }
        }
        return lo;
    }
    private boolean canDistribute(int[] quantities, int n, int maxQ) {
        int stores = 0;
        for (int q : quantities) { stores += (q + maxQ - 1) / maxQ; }
        return stores <= n;
    }
}
