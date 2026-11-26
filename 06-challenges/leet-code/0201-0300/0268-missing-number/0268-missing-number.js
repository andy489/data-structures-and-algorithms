// https://leetcode.com/problems/missing-number/

// Solution: Gauss Sum — O(n) time, O(1) space
var missingNumber = function(nums) {
    const n = nums.length;
    let expected = n * (n + 1) / 2;
    for (const num of nums) expected -= num;
    return expected;
};
