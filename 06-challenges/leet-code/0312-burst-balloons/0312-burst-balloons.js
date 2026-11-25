// https://leetcode.com/problems/burst-balloons/

var maxCoins = function(nums) {
    const arr = [1, ...nums, 1];
    const m = arr.length;
    const dp = Array.from({length: m}, () => new Array(m).fill(0));
    for (let len = 2; len < m; len++) {
        for (let l = 0; l < m - len; l++) {
            const r = l + len;
            for (let k = l + 1; k < r; k++) {
                dp[l][r] = Math.max(dp[l][r], dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r]);
            }
        }
    }
    return dp[0][m - 1];
};
