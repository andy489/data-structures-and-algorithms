// https://leetcode.com/problems/132-pattern/

var find132pattern = function(nums) {
    const stack = [];
    let third = -Infinity; // the "2" in 132 (middle value)
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] < third) {
            return true;
        }
        while (stack.length && nums[i] > stack[stack.length - 1]) {
            third = stack.pop();
        }
        stack.push(nums[i]);
    }
    return false;
};
