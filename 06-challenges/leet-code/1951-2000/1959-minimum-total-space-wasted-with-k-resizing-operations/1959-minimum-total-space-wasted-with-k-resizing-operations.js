// https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
var minSpaceWastedKResizing = function(nums, k) {
    const n = nums.length;
    const INF = Infinity;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    const dp = Array.from({length: n + 1}, () => new Array(k + 2).fill(INF));
    dp[0][0] = 0;

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= k + 1; j++) {
            let maxVal = 0;
            for (let l = i; l >= 1; l--) {
                maxVal = Math.max(maxVal, nums[l - 1]);
                const s = prefix[i] - prefix[l - 1];
                const waste = maxVal * (i - l + 1) - s;
                if (dp[l - 1][j - 1] !== INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - 1] + waste);
                }
            }
        }
    }

    let ans = INF;
    for (let j = 1; j <= k + 1; j++) {
        ans = Math.min(ans, dp[n][j]);
    }
    return ans;
};
