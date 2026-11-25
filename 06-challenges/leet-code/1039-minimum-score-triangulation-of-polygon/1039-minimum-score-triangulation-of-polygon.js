// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

var minScoreTriangulation = function(values) {
    const n = values.length;
    const dp = Array.from({length:n}, () => new Array(n).fill(0));
    for (let len = 2; len < n; len++) {
        for (let i = 0; i + len < n; i++) {
            const j = i + len;
            dp[i][j] = Infinity;
            for (let k = i+1; k < j; k++) {
                dp[i][j] = Math.min(dp[i][j], dp[i][k] + values[i]*values[k]*values[j] + dp[k][j]);
            }
        }
    }
    return dp[0][n-1];
};
