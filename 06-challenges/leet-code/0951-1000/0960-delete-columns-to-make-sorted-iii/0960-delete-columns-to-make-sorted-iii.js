// https://leetcode.com/problems/delete-columns-to-make-sorted-iii/

var minDeletionSize = function(strs) {
    const n = strs.length, m = strs[0].length;
    const dp = new Array(m).fill(1);
    for (let j = 1; j < m; j++) {
        for (let i = 0; i < j; i++) {
            if (strs.every(s => s[i] <= s[j])) {
                dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }
    }
    return m - Math.max(...dp);
};
