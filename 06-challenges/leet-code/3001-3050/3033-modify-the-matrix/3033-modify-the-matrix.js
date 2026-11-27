// https://leetcode.com/problems/modify-the-matrix/

var modifiedMatrix = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    for (let j = 0; j < n; j++) {
        let colMax = -1;
        for (let i = 0; i < m; i++) colMax = Math.max(colMax, matrix[i][j]);
        for (let i = 0; i < m; i++) if (matrix[i][j] === -1) matrix[i][j] = colMax;
    }
    return matrix;
};
