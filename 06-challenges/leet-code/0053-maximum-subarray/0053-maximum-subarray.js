// https://leetcode.com/problems/maximum-subarray/

var maxSubArray = function(nums) {
    let maxSum = nums[0], curr = nums[0];
    for (let i = 1; i < nums.length; i++) {
        curr = Math.max(nums[i], curr + nums[i]);
        maxSum = Math.max(maxSum, curr);
    }
    return maxSum;
};

// Solution 2: Divide and Conquer — O(n log n) time, O(log n) space
var maxSubArray2 = function(nums) {
    function solve(lo, hi) {
        if (lo === hi) return nums[lo];
        const mid = (lo + hi) >> 1;
        const left = solve(lo, mid);
        const right = solve(mid + 1, hi);
        let leftSum = -Infinity, s = 0;
        for (let i = mid; i >= lo; i--) { s += nums[i]; leftSum = Math.max(leftSum, s); }
        let rightSum = -Infinity;
        s = 0;
        for (let i = mid + 1; i <= hi; i++) { s += nums[i]; rightSum = Math.max(rightSum, s); }
        return Math.max(left, right, leftSum + rightSum);
    }
    return solve(0, nums.length - 1);
};
