// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

// Solution: Bitmask Enumeration — O(2^n) time, O(1) space
var countMaxOrSubsets = function(nums) {
    const maxOr = nums.reduce((a, b) => a | b, 0);
    let count = 0;
    for (let mask = 1; mask < (1 << nums.length); mask++) {
        let or = 0;
        for (let i = 0; i < nums.length; i++) { if (mask >> i & 1) or |= nums[i]; }
        if (or === maxOr) count++;
    }
    return count;
};
