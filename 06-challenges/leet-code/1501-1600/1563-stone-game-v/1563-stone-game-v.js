// https://leetcode.com/problems/stone-game-v/

var stoneGameV = function(stoneValue) {
    const n = stoneValue.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + stoneValue[i];
    }
    const dp = Array.from({length: n}, () => new Array(n).fill(0));
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            for (let k = i; k < j; k++) {
                const left = prefix[k + 1] - prefix[i];
                const right = prefix[j + 1] - prefix[k + 1];
                if (left < right) {
                    dp[i][j] = Math.max(dp[i][j], left + dp[i][k]);
                } else if (left > right) {
                    dp[i][j] = Math.max(dp[i][j], right + dp[k + 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], left + dp[i][k], right + dp[k + 1][j]);
                }
            }
        }
    }
    return dp[0][n - 1];
};
