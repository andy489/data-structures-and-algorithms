// https://leetcode.com/problems/distinct-subsequences/

// Solution 1: 2D DP — O(m·n) time, O(m·n) space
var numDistinct = function(s, t) {
    const m = t.length, n = s.length;
    const dp = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(0));

    for (let j = 0; j <= n; j++) {
        dp[0][j] = 1;
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            dp[i][j] = dp[i][j - 1];
            if (s[j - 1] === t[i - 1]) {
                dp[i][j] += dp[i - 1][j - 1];
            }
        }
    }

    return dp[m][n];
};

// Solution 2: 1D DP (Space-Optimised) — O(m·n) time, O(m) space
var numDistinct2 = function(s, t) {
    const m = t.length;
    const dp = new Array(m + 1).fill(0);
    dp[0] = 1;

    for (const c of s) {
        for (let i = m; i >= 1; i--) {
            if (c === t[i - 1]) {
                dp[i] += dp[i - 1];
            }
        }
    }

    return dp[m];
};
