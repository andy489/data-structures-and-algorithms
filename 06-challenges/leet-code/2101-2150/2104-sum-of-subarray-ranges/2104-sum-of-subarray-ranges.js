// https://leetcode.com/problems/sum-of-subarray-ranges/

// Solution: Brute Force — O(n^2) time, O(1) space
var subArrayRanges = function(nums) {
    let sum = 0;
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        let curMin = nums[i], curMax = nums[i];
        for (let j = i + 1; j < n; j++) {
            curMin = Math.min(curMin, nums[j]);
            curMax = Math.max(curMax, nums[j]);
            sum += curMax - curMin;
        }
    }

    return sum;
};

// Solution 2: Monotonic Stack — O(n) time, O(n) space
var subArrayRanges2 = function(nums) {
    function subarraySum(findMax) {
        const n = nums.length;
        const left = new Array(n), right = new Array(n);
        const stack = [];

        for (let i = 0; i < n; i++) {
            while (stack.length && (findMax ? nums[stack[stack.length-1]] <= nums[i] : nums[stack[stack.length-1]] >= nums[i])) {
                stack.pop();
            }
            left[i] = stack.length === 0 ? i + 1 : i - stack[stack.length-1];
            stack.push(i);
        }

        stack.length = 0;

        for (let i = n - 1; i >= 0; i--) {
            while (stack.length && (findMax ? nums[stack[stack.length-1]] < nums[i] : nums[stack[stack.length-1]] > nums[i])) {
                stack.pop();
            }
            right[i] = stack.length === 0 ? n - i : stack[stack.length-1] - i;
            stack.push(i);
        }

        return nums.reduce((s, v, i) => s + v * left[i] * right[i], 0);
    }

    return subarraySum(true) - subarraySum(false);
};
