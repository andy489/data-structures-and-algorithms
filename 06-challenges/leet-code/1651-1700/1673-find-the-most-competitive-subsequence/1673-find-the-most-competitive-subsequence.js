// https://leetcode.com/problems/find-the-most-competitive-subsequence/

var mostCompetitive = function(nums, k) {
    const n = nums.length;
    const stack = [];
    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && stack[stack.length - 1] > nums[i] && stack.length + (n - i) > k) {
            stack.pop();
        }
        if (stack.length < k) {
            stack.push(nums[i]);
        }
    }
    return stack;
};
