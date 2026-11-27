// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

var dominantIndex = function(nums) {
    let maxIdx = 0;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[maxIdx]) maxIdx = i;
    }
    for (let i = 0; i < nums.length; i++) {
        if (i !== maxIdx && nums[maxIdx] < 2 * nums[i]) return -1;
    }
    return maxIdx;
};
