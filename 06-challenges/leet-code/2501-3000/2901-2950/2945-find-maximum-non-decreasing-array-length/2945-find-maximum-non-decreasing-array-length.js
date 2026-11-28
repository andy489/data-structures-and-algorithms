// https://leetcode.com/problems/find-maximum-non-decreasing-array-length/

var findMaximumLength = function(nums) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }
    const dp = new Array(n + 1).fill(0);
    const last = new Array(n + 1).fill(0);
    const deque = [0];

    for (let i = 1; i <= n; i++) {
        while (deque.length > 1 && last[deque[0]] > prefix[i] - prefix[deque[0]]) {
            deque.shift();
        }
        const j = deque[0];
        dp[i] = dp[j] + 1;
        last[i] = prefix[i] - prefix[j];
        while (deque.length && dp[i] >= dp[deque[deque.length - 1]] && last[i] <= last[deque[deque.length - 1]]) {
            deque.pop();
        }
        deque.push(i);
    }

    return dp[n];
};
