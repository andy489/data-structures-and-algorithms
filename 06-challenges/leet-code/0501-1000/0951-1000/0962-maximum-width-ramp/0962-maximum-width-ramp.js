// https://leetcode.com/problems/maximum-width-ramp/

var maxWidthRamp = function(nums) {
    const n = nums.length;
    const stack = [];
    for (let i = 0; i < n; i++) {
        if (!stack.length || nums[stack[stack.length-1]] > nums[i]) stack.push(i);
    }
    let ans = 0;
    for (let j = n - 1; j >= 0; j--) {
        while (stack.length && nums[stack[stack.length-1]] <= nums[j]) {
            ans = Math.max(ans, j - stack.pop());
        }
    }
    return ans;
};
