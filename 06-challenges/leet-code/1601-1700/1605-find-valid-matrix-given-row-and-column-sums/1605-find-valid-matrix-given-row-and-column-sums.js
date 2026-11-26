// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

var restoreMatrix = function(rowSum, colSum) {
    const m = rowSum.length, n = colSum.length;
    const matrix = Array.from({length: m}, () => new Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const val = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;
        }
    }
    return matrix;
};
