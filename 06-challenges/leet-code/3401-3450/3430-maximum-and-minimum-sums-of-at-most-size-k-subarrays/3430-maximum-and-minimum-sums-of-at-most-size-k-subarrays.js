// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minMaxSubarraySum = function(nums, k) {
    const n = nums.length;

    const getBoundaries = (isMax) => {
        const left = new Array(n).fill(-1);
        const right = new Array(n).fill(n);
        let stack = [];
        for (let i = 0; i < n; i++) {
            while (stack.length && (isMax ? nums[stack[stack.length-1]] <= nums[i]
                                          : nums[stack[stack.length-1]] >= nums[i])) {
                stack.pop();
            }
            left[i] = stack.length ? stack[stack.length-1] : -1;
            stack.push(i);
        }
        stack = [];
        for (let i = n - 1; i >= 0; i--) {
            while (stack.length && (isMax ? nums[stack[stack.length-1]] < nums[i]
                                          : nums[stack[stack.length-1]] > nums[i])) {
                stack.pop();
            }
            right[i] = stack.length ? stack[stack.length-1] : n;
            stack.push(i);
        }
        return [left, right];
    };

    const countSubarrays = (i, left, right) => {
        const leftSpan = Math.min(i - left, k);
        const rightSpan = Math.min(right - i, k);
        let count = 0;
        for (let dl = 0; dl < leftSpan; dl++) {
            count += Math.min(rightSpan, k - dl);
        }
        return count;
    };

    const [leftMax, rightMax] = getBoundaries(true);
    const [leftMin, rightMin] = getBoundaries(false);

    let ans = 0;
    for (let i = 0; i < n; i++) {
        ans += nums[i] * countSubarrays(i, leftMax[i], rightMax[i]);
        ans += nums[i] * countSubarrays(i, leftMin[i], rightMin[i]);
    }
    return ans;
};
