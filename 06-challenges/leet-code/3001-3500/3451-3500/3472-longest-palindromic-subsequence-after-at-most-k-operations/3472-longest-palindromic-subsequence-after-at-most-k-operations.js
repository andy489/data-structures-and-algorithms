// https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/

var longestPalindromicSubsequence = function(s, k) {
    const n = s.length;
    // dp[i][j][b] = LPS of s[i..j] with at most b operations
    const dp = Array.from({length: n}, () =>
        Array.from({length: n}, () => new Array(k + 1).fill(0))
    );
    for (let i = 0; i < n; i++) {
        for (let b = 0; b <= k; b++) {
            dp[i][i][b] = 1;
        }
    }
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i + len - 1 < n; i++) {
            const j = i + len - 1;
            for (let b = 0; b <= k; b++) {
                const diff = Math.abs(s.charCodeAt(i) - s.charCodeAt(j));
                const cost = Math.min(diff, 26 - diff);
                let best = Math.max(dp[i + 1][j][b], dp[i][j - 1][b]);
                if (b >= cost) {
                    const inner = (len === 2) ? 0 : dp[i + 1][j - 1][b - cost];
                    best = Math.max(best, inner + 2);
                }
                dp[i][j][b] = best;
            }
        }
    }
    return dp[0][n - 1][k];
};
