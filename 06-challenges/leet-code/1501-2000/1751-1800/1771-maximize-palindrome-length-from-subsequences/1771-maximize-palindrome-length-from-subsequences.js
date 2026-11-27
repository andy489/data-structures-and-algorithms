// https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/

var longestPalindrome = function(word1, word2) {
    const s = word1 + word2;
    const n1 = word1.length, len = s.length;
    const dp = Array.from({length: len}, () => new Array(len).fill(0));
    for (let i = 0; i < len; i++) dp[i][i] = 1;
    let ans = 0;
    for (let size = 2; size <= len; size++) {
        for (let i = 0; i <= len - size; i++) {
            const j = i + size - 1;
            if (s[i] === s[j]) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
                if (i < n1 && j >= n1) {
                    ans = Math.max(ans, dp[i][j]);
                }
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }
    return ans;
};
