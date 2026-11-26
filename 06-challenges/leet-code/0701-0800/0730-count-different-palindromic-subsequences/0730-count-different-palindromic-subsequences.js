// https://leetcode.com/problems/count-different-palindromic-subsequences/

var countPalindromicSubsequences = function(s) {
    const MOD = 1e9 + 7;
    const n = s.length;
    const dp = Array.from({ length: n }, () => new Array(n).fill(0));
    for (let i = 0; i < n; i++) dp[i][i] = 1;
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            for (const c of ['a', 'b', 'c', 'd']) {
                let l = i, r = j;
                while (l <= j && s[l] !== c) l++;
                while (r >= i && s[r] !== c) r--;
                if (l > r) continue;
                else if (l === r) dp[i][j] += 1;
                else if (l + 1 === r) dp[i][j] += 2;
                else dp[i][j] += dp[l + 1][r - 1] + 2;
            }
            dp[i][j] %= MOD;
        }
    }
    return dp[0][n - 1];
};
