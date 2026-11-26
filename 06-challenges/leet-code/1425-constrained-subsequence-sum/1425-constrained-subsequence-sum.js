// https://leetcode.com/problems/constrained-subsequence-sum/

var constrainedSubsetSum = function(nums, k) {
    const n = nums.length, dp = new Array(n), dq = [];
    let ans = -Infinity;
    for (let i = 0; i < n; i++) {
        dp[i] = nums[i] + (dq.length ? Math.max(0, dp[dq[0]]) : 0);
        ans = Math.max(ans, dp[i]);
        while (dq.length && dp[dq[dq.length-1]] <= dp[i]) dq.pop();
        dq.push(i);
        if (i - dq[0] >= k) dq.shift();
    }
    return ans;
};
