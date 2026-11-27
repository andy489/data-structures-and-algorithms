// https://leetcode.com/problems/next-greater-element-ii/

var nextGreaterElements = function(nums) {
    const n = nums.length;
    const result = new Array(n).fill(-1);
    const stack = [];
    for (let i = 0; i < 2 * n; i++) {
        while (stack.length && nums[stack[stack.length - 1]] < nums[i % n]) {
            result[stack.pop()] = nums[i % n];
        }
        if (i < n) {
            stack.push(i);
        }
    }
    return result;
};
