// https://leetcode.com/problems/word-break-ii/

// Solution 1: Memoized DFS (Top-Down) — O(n·2ⁿ) time, O(n·2ⁿ) space
var wordBreak = function(s, wordDict) {
    const words = new Set(wordDict);
    const memo = new Map();
    function dfs(start) {
        if (memo.has(start)) return memo.get(start);
        if (start === s.length) return [""];
        const res = [];
        for (let end = start + 1; end <= s.length; end++) {
            const word = s.slice(start, end);
            if (words.has(word)) {
                for (const rest of dfs(end)) {
                    res.push(rest === "" ? word : word + " " + rest);
                }
            }
        }
        memo.set(start, res);
        return res;
    }
    return dfs(0);
};

// Solution 2: Bottom-Up DP — O(n·2ⁿ) time, O(n·2ⁿ) space
var wordBreak2 = function(s, wordDict) {
    const n = s.length;
    const dp = Array.from({length: n + 1}, () => []);
    dp[0] = [""];
    for (let i = 1; i <= n; i++) {
        for (const w of wordDict) {
            const l = w.length;
            if (i >= l && s.slice(i - l, i) === w && dp[i - l].length) {
                for (const prev of dp[i - l]) {
                    dp[i].push(prev === "" ? w : prev + " " + w);
                }
            }
        }
    }
    return dp[n];
};
