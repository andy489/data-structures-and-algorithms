// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

// Solution: Binary Search — O(m·log(m·n)) time, O(1) space
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (count(mid, m, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int count(int x, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(x / i, n);
        }
        return cnt;
    }
}
