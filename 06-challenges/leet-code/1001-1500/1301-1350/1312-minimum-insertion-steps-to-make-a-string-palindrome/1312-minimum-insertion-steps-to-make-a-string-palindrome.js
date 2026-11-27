// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

var minInsertions = function(s) {
    const n = s.length;
    const dp = Array.from({length:n}, ()=>new Array(n).fill(0));
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i+len-1 < n; i++) {
            const j = i+len-1;
            dp[i][j] = s[i]===s[j] ? (len>2 ? dp[i+1][j-1] : 0) : 1+Math.min(dp[i+1][j],dp[i][j-1]);
        }
    }
    return dp[0][n-1];
};
