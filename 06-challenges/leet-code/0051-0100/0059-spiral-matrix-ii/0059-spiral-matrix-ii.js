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

// Solution 2: Recursion — O(n²) time, O(n) space
var generateMatrix2 = function(n) {
    const matrix = Array.from({length: n}, () => new Array(n).fill(0));
    function fill(offset, size, num) {
        if (size === 0) return;
        if (size === 1) { matrix[offset][offset] = num; return; }
        for (let c = offset; c < offset + size - 1; c++) matrix[offset][c] = num++;
        for (let r = offset; r < offset + size - 1; r++) matrix[r][offset + size - 1] = num++;
        for (let c = offset + size - 1; c > offset; c--) matrix[offset + size - 1][c] = num++;
        for (let r = offset + size - 1; r > offset; r--) matrix[r][offset] = num++;
        fill(offset + 1, size - 2, num);
    }
    fill(0, n, 1);
    return matrix;
};
