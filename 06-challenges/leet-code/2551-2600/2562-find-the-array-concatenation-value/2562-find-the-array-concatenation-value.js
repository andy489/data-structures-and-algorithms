// https://leetcode.com/problems/find-the-array-concatenation-value/

// Solution: Two Pointers — O(n) time, O(1) space
var findTheArrayConcVal = function(nums) {
    let result = 0;
    let l = 0, r = nums.length - 1;
    while (l < r) {
        result += Number(String(nums[l]) + String(nums[r]));
        l++;
        r--;
    }
    if (l === r) {
        result += nums[l];
    }
    return result;
};
