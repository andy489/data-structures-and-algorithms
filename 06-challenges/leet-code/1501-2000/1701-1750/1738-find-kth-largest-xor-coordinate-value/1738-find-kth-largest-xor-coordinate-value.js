// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

var kthLargestValue = function(matrix, k) {
    const m = matrix.length, n = matrix[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            matrix[i][j] ^= matrix[i][j - 1];
        }
    }
    for (let j = 0; j < n; j++) {
        for (let i = 1; i < m; i++) {
            matrix[i][j] ^= matrix[i - 1][j];
        }
    }
    const vals = [];
    for (const row of matrix) {
        for (const v of row) {
            vals.push(v);
        }
    }
    vals.sort((a, b) => b - a);
    return vals[k - 1];
};
