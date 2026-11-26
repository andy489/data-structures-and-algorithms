// https://leetcode.com/problems/sliding-window-maximum/

// Solution: Monotonic Deque — O(n) time, O(k) space
var maxSlidingWindow = function(nums, k) {
    const deque = [], result = [];

    for (let i = 0; i < nums.length; i++) {
        while (deque.length && nums[deque[deque.length - 1]] <= nums[i]) deque.pop();
        deque.push(i);
        if (deque[0] < i - k + 1) deque.shift();
        if (i >= k - 1) result.push(nums[deque[0]]);
    }
    return result;
};
