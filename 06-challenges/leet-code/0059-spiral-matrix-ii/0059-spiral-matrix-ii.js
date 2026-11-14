// https://leetcode.com/problems/spiral-matrix-ii/

var generateMatrix = function(n) {
    const matrix = Array.from({length: n}, () => new Array(n).fill(0));
    let top = 0, bottom = n - 1, left = 0, right = n - 1, num = 1;
    while (num <= n * n) {
        for (let c = left; c <= right; c++) matrix[top][c] = num++;
        top++;
        for (let r = top; r <= bottom; r++) matrix[r][right] = num++;
        right--;
        for (let c = right; c >= left; c--) matrix[bottom][c] = num++;
        bottom--;
        for (let r = bottom; r >= top; r--) matrix[r][left] = num++;
        left++;
    }
    return matrix;
};
