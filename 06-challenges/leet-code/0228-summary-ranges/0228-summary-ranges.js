// https://leetcode.com/problems/summary-ranges/

// Solution: Linear Scan — O(n) time, O(1) space
var summaryRanges = function(nums) {
    const result = [];
    let i = 0;
    while (i < nums.length) {
        const start = nums[i];
        while (i + 1 < nums.length && nums[i + 1] === nums[i] + 1) i++;
        result.push(start === nums[i] ? `${start}` : `${start}->${nums[i]}`);
        i++;
    }
    return result;
};
