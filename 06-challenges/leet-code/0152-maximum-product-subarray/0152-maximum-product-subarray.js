// https://leetcode.com/problems/maximum-product-subarray/

// Solution 1: Track max and min — O(n) time, O(1) space
var maxProduct = function(nums) {
    let curMax = nums[0], curMin = nums[0], result = nums[0];
    for (let i = 1; i < nums.length; i++) {
        const n = nums[i];
        const tmpMax = Math.max(n, curMax * n, curMin * n);
        curMin = Math.min(n, curMax * n, curMin * n);
        curMax = tmpMax;
        result = Math.max(result, curMax);
    }
    return result;
};

// Solution 2: Forward + backward pass — O(n) time, O(1) space
var maxProduct2 = function(nums) {
    let result = -Infinity, prod = 1;
    for (const n of nums) { prod *= n; result = Math.max(result, prod); if (prod === 0) prod = 1; }
    prod = 1;
    for (let i = nums.length - 1; i >= 0; i--) { prod *= nums[i]; result = Math.max(result, prod); if (prod === 0) prod = 1; }
    return result;
};
