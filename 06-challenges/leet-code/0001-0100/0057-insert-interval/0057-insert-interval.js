// https://leetcode.com/problems/insert-interval/

var insert = function(intervals, newInterval) {
    const result = [];
    let i = 0, n = intervals.length;

    while (i < n && intervals[i][1] < newInterval[0]) {
        result.push(intervals[i++]);
    }
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    result.push(newInterval);
    while (i < n) {
        result.push(intervals[i++]);
    }

    return result;
};
