// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Solution: Two Pointers — O(n) time, O(1) space
var removeDuplicates = function(nums) {
    let k = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[k - 1]) {
            nums[k++] = nums[i];
        }
    }
    return k;
};
