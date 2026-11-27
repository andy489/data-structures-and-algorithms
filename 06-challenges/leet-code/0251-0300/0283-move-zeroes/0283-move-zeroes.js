// https://leetcode.com/problems/move-zeroes/

// Solution: Two-Pointer (Write Pointer) — O(n) time, O(1) space
var moveZeroes = function(nums) {
    let write = 0;
    for (const num of nums) {
        if (num !== 0) nums[write++] = num;
    }
    while (write < nums.length) nums[write++] = 0;
};
