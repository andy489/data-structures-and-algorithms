// https://leetcode.com/problems/non-overlapping-intervals/

var eraseOverlapIntervals = function(intervals) {
    intervals.sort((a, b) => a[1] - b[1]);
    let removed = 0;
    let prevEnd = -Infinity;
    for (const [start, end] of intervals) {
        if (start >= prevEnd) {
            prevEnd = end;
        } else {
            removed++;
        }
    }
    return removed;
};
