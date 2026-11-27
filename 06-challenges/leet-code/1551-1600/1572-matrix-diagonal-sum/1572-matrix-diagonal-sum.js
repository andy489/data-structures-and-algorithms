// https://leetcode.com/problems/matrix-diagonal-sum/

var diagonalSum = function(mat) {
    const n = mat.length;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        sum += mat[i][i] + mat[i][n - 1 - i];
    }
    if (n % 2 === 1) {
        sum -= mat[Math.floor(n / 2)][Math.floor(n / 2)];
    }
    return sum;
};
