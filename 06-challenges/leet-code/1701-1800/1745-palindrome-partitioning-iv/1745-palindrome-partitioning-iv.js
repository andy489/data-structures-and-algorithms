// https://leetcode.com/problems/palindrome-partitioning-iv/

var checkPartitioning = function(s) {
    const n = s.length;
    const isPalin = Array.from({length: n}, () => new Array(n).fill(false));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = i; j < n; j++) {
            if (s[i] === s[j] && (j - i <= 2 || isPalin[i + 1][j - 1])) {
                isPalin[i][j] = true;
            }
        }
    }
    for (let i = 1; i < n - 1; i++) {
        for (let j = i; j < n - 1; j++) {
            if (isPalin[0][i - 1] && isPalin[i][j] && isPalin[j + 1][n - 1]) {
                return true;
            }
        }
    }
    return false;
};
