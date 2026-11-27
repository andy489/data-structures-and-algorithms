// https://leetcode.com/problems/count-the-hidden-sequences/
var numberOfArrays = function(differences, lower, upper) {
    let prefix = 0;
    let minVal = 0;
    let maxVal = 0;
    for (const d of differences) {
        prefix += d;
        minVal = Math.min(minVal, prefix);
        maxVal = Math.max(maxVal, prefix);
    }
    return Math.max((upper - lower) - (maxVal - minVal) + 1, 0);
};
