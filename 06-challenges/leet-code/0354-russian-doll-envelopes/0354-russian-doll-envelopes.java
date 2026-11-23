// https://leetcode.com/problems/russian-doll-envelopes/

// Solution: Sort + LIS with Binary Search — O(n log n) time, O(n) space
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[] tails = new int[envelopes.length];
        int len = 0;
        for (int[] e : envelopes) {
            int h = e[1];
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < h) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = h;
            if (lo == len) {
                len++;
            }
        }
        return len;
    }
}
