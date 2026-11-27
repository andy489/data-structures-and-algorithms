/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function (mat, r, c) {
    const m = mat.length, n = mat[0].length;
    if (m * n !== r * c) {
        return mat;
    }
    const result = Array.from({ length: r }, () => new Array(c));
    for (let i = 0; i < m * n; i++) {
        result[Math.floor(i / c)][i % c] = mat[Math.floor(i / n)][i % n];
    }
    return result;
};
