// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

var minOperations = function(nums, x) {
    const target = nums.reduce((a, b) => a + b, 0) - x;
    if (target < 0) {
        return -1;
    }
    if (target === 0) {
        return nums.length;
    }
    let maxLen = -1, windowSum = 0, l = 0;
    for (let r = 0; r < nums.length; r++) {
        windowSum += nums[r];
        while (windowSum > target) {
            windowSum -= nums[l++];
        }
        if (windowSum === target) {
            maxLen = Math.max(maxLen, r - l + 1);
        }
    }
    return maxLen === -1 ? -1 : nums.length - maxLen;
};
