// https://leetcode.com/problems/find-maximum-removals-from-source-string/

/**
 * @param {string} source
 * @param {string} pattern
 * @param {number[]} targetIndices
 * @return {number}
 */
var maxRemovals = function (source, pattern, targetIndices) {
    const n = source.length, m = pattern.length;
    const targets = new Set(targetIndices);
    const NEG_INF = -Infinity;
    let dp = new Array(m + 1).fill(NEG_INF);
    dp[0] = 0;
    for (let i = 0; i < n; i++) {
        const ndp = [...dp];
        const isTarget = targets.has(i);
        for (let j = 0; j <= m; j++) {
            if (dp[j] === NEG_INF) {
                continue;
            }
            if (isTarget) {
                ndp[j] = Math.max(ndp[j], dp[j] + 1);
            }
            if (j < m && source[i] === pattern[j]) {
                ndp[j + 1] = Math.max(ndp[j + 1], dp[j]);
            }
        }
        dp = ndp;
    }
    return dp[m];
};
