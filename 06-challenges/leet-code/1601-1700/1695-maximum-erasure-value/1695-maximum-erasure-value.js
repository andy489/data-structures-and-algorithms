// https://leetcode.com/problems/maximum-erasure-value/

var maximumUniqueSubarray = function(nums) {
    const lastSeen = new Map();
    let maxSum = 0, windowSum = 0, l = 0;
    for (let r = 0; r < nums.length; r++) {
        if (lastSeen.has(nums[r]) && lastSeen.get(nums[r]) >= l) {
            const prev = lastSeen.get(nums[r]);
            while (l <= prev) {
                windowSum -= nums[l++];
            }
        }
        windowSum += nums[r];
        lastSeen.set(nums[r], r);
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
};
