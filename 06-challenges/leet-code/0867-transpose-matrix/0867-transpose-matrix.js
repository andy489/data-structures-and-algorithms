// https://leetcode.com/problems/transpose-matrix/

var transpose = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    return Array.from({length: n}, (_, j) => Array.from({length: m}, (_, i) => matrix[i][j]));
};
