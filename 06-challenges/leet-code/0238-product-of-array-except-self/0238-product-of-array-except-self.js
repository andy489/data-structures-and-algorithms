// https://leetcode.com/problems/product-of-array-except-self/

// Solution: Prefix + Suffix Products — O(n) time, O(1) extra space
var productExceptSelf = function(nums) {
    const n = nums.length;
    const answer = new Array(n).fill(1);
    for (let i = 1; i < n; i++) answer[i] = answer[i - 1] * nums[i - 1];
    let suffix = 1;
    for (let i = n - 1; i >= 0; i--) {
        answer[i] *= suffix;
        suffix *= nums[i];
    }
    return answer;
};
