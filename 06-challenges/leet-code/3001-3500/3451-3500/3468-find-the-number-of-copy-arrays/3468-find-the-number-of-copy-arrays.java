// https://leetcode.com/problems/find-the-number-of-copy-arrays/

// Solution: Interval Intersection — O(n) time, O(1) space
class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        long lo = Long.MIN_VALUE, hi = Long.MAX_VALUE;
        for (int i = 0; i < original.length; i++) {
            long diff = (long) original[i] - original[0];
            lo = Math.max(lo, (long) bounds[i][0] - diff);
            hi = Math.min(hi, (long) bounds[i][1] - diff);
        }
        return (int) Math.max(0, hi - lo + 1);
    }
}
