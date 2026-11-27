// https://leetcode.com/problems/merge-intervals/

var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const merged = [intervals[0]];
    for (let i = 1; i < intervals.length; i++) {
        const last = merged[merged.length - 1];
        if (intervals[i][0] <= last[1]) {
            last[1] = Math.max(last[1], intervals[i][1]);
        } else {
            merged.push(intervals[i]);
        }
    }
    return merged;
};
