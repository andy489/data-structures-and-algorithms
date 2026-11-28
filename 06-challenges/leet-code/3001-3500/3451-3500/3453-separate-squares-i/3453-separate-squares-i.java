// https://leetcode.com/problems/separate-squares-i/

// Solution: Binary Search on Answer — O(n log(max_y / eps)) time, O(1) space
class Solution {
    public double separateSquares(int[][] squares) {
        double lo = 0, hi = 2e9;
        for (int[] sq : squares) {
            lo = Math.min(lo, sq[1]);
            hi = Math.max(hi, sq[1] + sq[2]);
        }
        for (int iter = 0; iter < 100; iter++) {
            double mid = (lo + hi) / 2.0;
            double below = 0, above = 0;
            for (int[] sq : squares) {
                double y = sq[1], l = sq[2];
                double top = y + l;
                if (mid >= top) {
                    below += (double) l * l;
                } else if (mid <= y) {
                    above += (double) l * l;
                } else {
                    below += (mid - y) * l;
                    above += (top - mid) * l;
                }
            }
            if (below < above) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
