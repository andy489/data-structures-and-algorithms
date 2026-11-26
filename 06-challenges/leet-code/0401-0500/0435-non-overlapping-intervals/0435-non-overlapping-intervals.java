// https://leetcode.com/problems/non-overlapping-intervals/

// Solution: Greedy (Earliest End Time) — O(n log n) time, O(1) space
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int removed = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                removed++;
            }
        }
        return removed;
    }
}
