// https://leetcode.com/problems/minimum-time-difference/

var findMinDifference = function(timePoints) {
    const minutes = timePoints
        .map(tp => parseInt(tp.slice(0, 2), 10) * 60 + parseInt(tp.slice(3), 10))
        .sort((a, b) => a - b);
    const n = minutes.length;
    let minDiff = 1440 - minutes[n - 1] + minutes[0];
    for (let i = 1; i < n; i++) {
        minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
    }
    return minDiff;
};
