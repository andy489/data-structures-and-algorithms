// https://leetcode.com/problems/wildcard-matching/

var isMatch = function(s, p) {
    const m = s.length, n = p.length;
    const dp = Array.from({length: m + 1}, () => new Array(n + 1).fill(false));
    dp[0][0] = true;
    for (let j = 1; j <= n; j++) {
        if (p[j - 1] === '*') {
            dp[0][j] = dp[0][j - 1];
        }
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            const pc = p[j - 1];
            if (pc === s[i - 1] || pc === '?') {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (pc === '*') {
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
    }
    return dp[m][n];
};
