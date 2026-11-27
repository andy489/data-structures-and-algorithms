// https://leetcode.com/problems/strange-printer/

var strangePrinter = function(s) {
    const n = s.length;
    const dp = Array.from({length: n}, () => new Array(n).fill(0));
    for (let i = n - 1; i >= 0; i--) {
        dp[i][i] = 1;
        for (let j = i + 1; j < n; j++) {
            dp[i][j] = 1 + dp[i + 1][j];
            for (let k = i + 1; k <= j; k++) {
                if (s[k] === s[i]) {
                    const left = k > i + 1 ? dp[i + 1][k - 1] : 0;
                    dp[i][j] = Math.min(dp[i][j], left + dp[k][j]);
                }
            }
        }
    }
    return dp[0][n - 1];
};
