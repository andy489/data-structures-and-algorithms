// https://leetcode.com/problems/sum-of-beauty-in-the-array/

// Solution: Prefix Max / Suffix Min — O(n) time, O(n) space
var sumOfBeauties = function(nums) {
    const n = nums.length;
    const prefMax = new Array(n), sufMin = new Array(n);
    prefMax[0] = nums[0];
    for (let i = 1; i < n; i++) prefMax[i] = Math.max(prefMax[i-1], nums[i]);
    sufMin[n-1] = nums[n-1];
    for (let i = n-2; i >= 0; i--) sufMin[i] = Math.min(sufMin[i+1], nums[i]);
    let res = 0;
    for (let i = 1; i < n-1; i++) {
        if (prefMax[i-1] < nums[i] && nums[i] < sufMin[i+1]) res += 2;
        else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) res += 1;
    }
    return res;
};
