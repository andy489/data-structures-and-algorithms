// https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

/**
 * @param {number[][]} coins
 * @return {number}
 */
var maximumAmount = function(coins) {
    const m = coins.length, n = coins[0].length;
    const NEG_INF = -Infinity;
    // dp[i][j][k] = max coins at (i,j) with k neutralizations used (0,1,2)
    const dp = Array.from({length: m}, () =>
        Array.from({length: n}, () => new Array(3).fill(NEG_INF))
    );
    for (let k = 0; k <= 2; k++) {
        dp[0][0][k] = (coins[0][0] < 0 && k > 0) ? 0 : coins[0][0];
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i === 0 && j === 0) continue;
            for (let k = 0; k <= 2; k++) {
                let prev = NEG_INF;
                if (i > 0 && dp[i-1][j][k] !== NEG_INF) prev = Math.max(prev, dp[i-1][j][k]);
                if (j > 0 && dp[i][j-1][k] !== NEG_INF) prev = Math.max(prev, dp[i][j-1][k]);
                if (prev === NEG_INF) continue;
                dp[i][j][k] = Math.max(dp[i][j][k], prev + coins[i][j]);
                if (coins[i][j] < 0 && k > 0) {
                    const pk = k - 1;
                    let prevK = NEG_INF;
                    if (i > 0) prevK = Math.max(prevK, dp[i-1][j][pk]);
                    if (j > 0) prevK = Math.max(prevK, dp[i][j-1][pk]);
                    if (prevK !== NEG_INF) dp[i][j][k] = Math.max(dp[i][j][k], prevK);
                }
            }
        }
    }
    return dp[m-1][n-1][2];
};
