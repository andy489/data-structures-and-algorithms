// https://leetcode.com/problems/arranging-coins/

// Solution: Binary Search — O(log n) time, O(1) space
class Solution {
    public int arrangeCoins(int n) {
        long lo = 1, hi = n;
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int) lo;
    }
}

// Solution 2: Math (Quadratic Formula) — O(1) time, O(1) space
class Solution2 {
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}
