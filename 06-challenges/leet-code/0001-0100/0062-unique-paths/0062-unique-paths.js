// https://leetcode.com/problems/unique-paths/

var uniquePaths = function(m, n) {
    const dp = new Array(n).fill(1);
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[j] += dp[j - 1];
        }
    }
    return dp[n - 1];
};

// Solution 2: Combinatorics — O(min(m,n)) time, O(1) space
var uniquePaths2 = function(m, n) {
    const k = Math.min(m, n) - 1;
    let result = 1;
    for (let i = 0; i < k; i++) {
        result = result * (m + n - 2 - i) / (i + 1);
    }
    return result;
};
