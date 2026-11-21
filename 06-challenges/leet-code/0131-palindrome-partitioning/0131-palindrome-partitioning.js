// https://leetcode.com/problems/palindrome-partitioning/

// Solution 1: Backtracking with inline palindrome check — O(n·2ⁿ) time, O(n) extra space
var partition = function(s) {
    const res = [];
    function backtrack(start, path) {
        if (start === s.length) { res.push([...path]); return; }
        for (let end = start; end < s.length; end++) {
            const sub = s.slice(start, end + 1);
            if (isPalin(sub)) {
                path.push(sub);
                backtrack(end + 1, path);
                path.pop();
            }
        }
    }
    function isPalin(t) {
        let l = 0, r = t.length - 1;
        while (l < r) { if (t[l++] !== t[r--]) return false; }
        return true;
    }
    backtrack(0, []);
    return res;
};

// Solution 2: Backtracking + DP palindrome table — O(n²) pre-computation, O(n·2ⁿ) backtracking
var partition2 = function(s) {
    const n = s.length;
    const dp = Array.from({length: n}, () => new Array(n).fill(false));
    for (let i = 0; i < n; i++) dp[i][i] = true;
    for (let i = 0; i < n - 1; i++) dp[i][i + 1] = (s[i] === s[i + 1]);
    for (let len = 3; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            dp[i][j] = (s[i] === s[j]) && dp[i + 1][j - 1];
        }
    }
    const res = [];
    function backtrack(start, path) {
        if (start === n) { res.push([...path]); return; }
        for (let end = start; end < n; end++) {
            if (dp[start][end]) {
                path.push(s.slice(start, end + 1));
                backtrack(end + 1, path);
                path.pop();
            }
        }
    }
    backtrack(0, []);
    return res;
};
