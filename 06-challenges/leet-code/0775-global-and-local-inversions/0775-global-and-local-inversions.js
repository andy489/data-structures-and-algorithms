// https://leetcode.com/problems/global-and-local-inversions/

var isIdealPermutation = function(nums) {
    let maxSoFar = 0;
    for (let i = 0; i < nums.length - 2; i++) {
        maxSoFar = Math.max(maxSoFar, nums[i]);
        if (maxSoFar > nums[i + 2]) {
            return false;
        }
    }
    return true;
};
