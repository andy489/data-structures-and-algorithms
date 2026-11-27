// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

var getSumAbsoluteDifferences = function(nums) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }
    const result = new Array(n);
    for (let i = 0; i < n; i++) {
        const left  = nums[i] * i - prefix[i];
        const right = (prefix[n] - prefix[i + 1]) - nums[i] * (n - 1 - i);
        result[i] = left + right;
    }
    return result;
};
