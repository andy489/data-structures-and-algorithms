// https://leetcode.com/problems/rotate-image/

var rotate = function(matrix) {
    const n = matrix.length;
    // transpose: matrix[i][j] <-> matrix[j][i]
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
        }
    }
    // reverse each row
    for (let i = 0; i < n; i++) {
        matrix[i].reverse();
    }
};
