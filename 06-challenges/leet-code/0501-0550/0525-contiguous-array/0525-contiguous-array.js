// https://leetcode.com/problems/contiguous-array/

var findMaxLength = function(nums) {
    const firstOccurrence = new Map([[0, -1]]);
    let prefixSum = 0, maxLen = 0;
    for (let i = 0; i < nums.length; i++) {
        prefixSum += nums[i] === 1 ? 1 : -1;
        if (firstOccurrence.has(prefixSum)) {
            maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum));
        } else {
            firstOccurrence.set(prefixSum, i);
        }
    }
    return maxLen;
};
