// https://leetcode.com/problems/largest-submatrix-with-rearrangements/

var largestSubmatrix = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    for (let i = 1; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 1) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
    }
    let ans = 0;
    for (let i = 0; i < m; i++) {
        const row = matrix[i].slice().sort((a, b) => b - a);
        for (let j = 0; j < n; j++) {
            if (row[j] === 0) {
                break;
            }
            ans = Math.max(ans, row[j] * (j + 1));
        }
    }
    return ans;
};
