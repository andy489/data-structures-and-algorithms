// https://leetcode.com/problems/height-checker/

var heightChecker = function(heights) {
    const sorted = [...heights].sort((a, b) => a - b);
    return heights.reduce((cnt, h, i) => cnt + (h !== sorted[i] ? 1 : 0), 0);
};
