// https://leetcode.com/problems/teemo-attacking/

var findPoisonedDuration = function(timeSeries, duration) {
    let total = 0;
    for (let i = 0; i < timeSeries.length - 1; i++) {
        total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
    }
    total += duration;
    return total;
};
