// https://leetcode.com/problems/stone-game-ii/

var stoneGameII = function(piles) {
    const n = piles.length;
    const suffix = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        suffix[i] = suffix[i + 1] + piles[i];
    }
    const dp = Array.from({length: n + 1}, () => new Array(n + 1).fill(0));
    for (let i = n - 1; i >= 0; i--) {
        for (let m = 1; m <= n; m++) {
            if (i + 2 * m >= n) {
                dp[i][m] = suffix[i];
            } else {
                for (let x = 1; x <= 2 * m; x++) {
                    dp[i][m] = Math.max(dp[i][m], suffix[i] - dp[i + x][Math.max(m, x)]);
                }
            }
        }
    }
    return dp[0][1];
};
