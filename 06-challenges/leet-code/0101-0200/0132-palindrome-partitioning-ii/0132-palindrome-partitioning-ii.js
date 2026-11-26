// https://leetcode.com/problems/palindrome-partitioning-ii/

// Solution 1: DP + Expand-Around-Center — O(n²) time, O(n) space
var minCut = function(s) {
    const n = s.length;
    const cut = Array.from({length: n}, (_, i) => i);
    for (let c = 0; c < n; c++) {
        // odd-length
        for (let k = 0; c - k >= 0 && c + k < n && s[c - k] === s[c + k]; k++) {
            const [l, r] = [c - k, c + k];
            cut[r] = l === 0 ? 0 : Math.min(cut[r], cut[l - 1] + 1);
        }
        // even-length
        for (let k = 1; c - k + 1 >= 0 && c + k < n && s[c - k + 1] === s[c + k]; k++) {
            const [l, r] = [c - k + 1, c + k];
            cut[r] = l === 0 ? 0 : Math.min(cut[r], cut[l - 1] + 1);
        }
    }
    return cut[n - 1];
};

// Solution 2: DP + 2-D Palindrome Table — O(n²) time, O(n²) space
var minCut2 = function(s) {
    const n = s.length;
    const isPalin = Array.from({length: n}, () => new Array(n).fill(false));
    for (let i = 0; i < n; i++) isPalin[i][i] = true;
    for (let i = 0; i < n - 1; i++) isPalin[i][i + 1] = (s[i] === s[i + 1]);
    for (let len = 3; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            isPalin[i][j] = (s[i] === s[j]) && isPalin[i + 1][j - 1];
        }
    }
    const cut = Array.from({length: n}, (_, i) => i);
    for (let i = 0; i < n; i++) {
        if (isPalin[0][i]) { cut[i] = 0; continue; }
        for (let j = 1; j <= i; j++) {
            if (isPalin[j][i]) cut[i] = Math.min(cut[i], cut[j - 1] + 1);
        }
    }
    return cut[n - 1];
};
