// https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/

var minimumCost = function(nums, cost, k) {
    const n = nums.length;

    const prefNums = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefNums[i + 1] = prefNums[i] + nums[i];
    }

    const suffCost = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        suffCost[i] = suffCost[i + 1] + cost[i];
    }

    const INF = Number.MAX_SAFE_INTEGER;
    const dp = new Array(n + 1).fill(INF);
    dp[0] = 0;

    for (let r = 1; r <= n; r++) {
        let minVal = INF;
        for (let l = 0; l < r; l++) {
            if (dp[l] < INF) {
                const candidate = dp[l] + (prefNums[r] + k) * suffCost[l];
                if (candidate < minVal) {
                    minVal = candidate;
                }
            }
        }
        dp[r] = minVal - prefNums[r] * suffCost[r];
    }

    return dp[n];
};
