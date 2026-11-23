// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

var minMoves = function(nums) {
    const minVal = Math.min(...nums);
    return nums.reduce((sum, n) => sum + n - minVal, 0);
};
