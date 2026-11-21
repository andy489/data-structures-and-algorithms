// https://leetcode.com/problems/word-break/

// Solution 1: Bottom-Up DP — O(n²·m) time, O(n) space
var wordBreak = function(s, wordDict) {
    const words = new Set(wordDict);
    const n = s.length;
    const dp = new Array(n + 1).fill(false);
    dp[0] = true;
    for (let i = 1; i <= n; i++) {
        for (const w of words) {
            const l = w.length;
            if (i >= l && dp[i - l] && s.slice(i - l, i) === w) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
};

// Solution 2: Top-Down Memoized DFS — O(n²) time, O(n) space
var wordBreak2 = function(s, wordDict) {
    const words = new Set(wordDict);
    const memo = new Map();
    function dfs(start) {
        if (start === s.length) return true;
        if (memo.has(start)) return memo.get(start);
        for (let end = start + 1; end <= s.length; end++) {
            if (words.has(s.slice(start, end)) && dfs(end)) {
                memo.set(start, true);
                return true;
            }
        }
        memo.set(start, false);
        return false;
    }
    return dfs(0);
};
