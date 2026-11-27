// https://leetcode.com/problems/maximal-square/

// Solution: 2D DP — O(m·n) time, O(m·n) space
var maximalSquare = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const dp = Array.from({ length: m }, () => new Array(n).fill(0));
    let maxSide = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '1') {
                dp[i][j] = (i === 0 || j === 0) ? 1
                    : Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
    }
    return maxSide * maxSide;
};

// Solution 2: O(n) Space DP
var maximalSquare2 = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const dp = new Array(n).fill(0);
    let maxSide = 0, prev = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const temp = dp[j];
            if (matrix[i][j] === '1') {
                dp[j] = (i === 0 || j === 0) ? 1
                    : Math.min(dp[j], dp[j-1], prev) + 1;
                maxSide = Math.max(maxSide, dp[j]);
            } else {
                dp[j] = 0;
            }
            prev = temp;
        }
    }
    return maxSide * maxSide;
};
