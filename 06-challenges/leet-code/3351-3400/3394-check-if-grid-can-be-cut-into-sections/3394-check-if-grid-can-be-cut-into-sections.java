// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

// Solution: Interval Merge — O(n log n) time, O(n) space
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return hasEnoughGaps(rectangles, true) || hasEnoughGaps(rectangles, false);
    }

    private boolean hasEnoughGaps(int[][] rects, boolean horizontal) {
        int[][] intervals = new int[rects.length][2];
        for (int i = 0; i < rects.length; i++) {
            if (horizontal) {
                intervals[i][0] = rects[i][1];
                intervals[i][1] = rects[i][3];
            } else {
                intervals[i][0] = rects[i][0];
                intervals[i][1] = rects[i][2];
            }
        }
        java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int gaps = 0;
        int maxEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= maxEnd) {
                gaps++;
                if (gaps >= 2) {
                    return true;
                }
            }
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }
        return false;
    }
}
