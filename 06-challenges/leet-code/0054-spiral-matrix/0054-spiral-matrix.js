// https://leetcode.com/problems/spiral-matrix/

var spiralOrder = function(matrix) {
    const result = [];
    let top = 0, bottom = matrix.length - 1;
    let left = 0, right = matrix[0].length - 1;
    while (top <= bottom && left <= right) {
        for (let c = left; c <= right; c++) result.push(matrix[top][c]);
        top++;
        for (let r = top; r <= bottom; r++) result.push(matrix[r][right]);
        right--;
        if (top <= bottom) {
            for (let c = right; c >= left; c--) result.push(matrix[bottom][c]);
            bottom--;
        }
        if (left <= right) {
            for (let r = bottom; r >= top; r--) result.push(matrix[r][left]);
            left++;
        }
    }
    return result;
};

// Solution 2: Recursion — O(m·n) time, O(min(m,n)) space
var spiralOrder2 = function(matrix) {
    const result = [];
    function solve(top, bottom, left, right) {
        if (top > bottom || left > right) return;
        for (let c = left; c <= right; c++) result.push(matrix[top][c]);
        for (let r = top + 1; r <= bottom; r++) result.push(matrix[r][right]);
        if (top < bottom) {
            for (let c = right - 1; c >= left; c--) result.push(matrix[bottom][c]);
        }
        if (left < right) {
            for (let r = bottom - 1; r > top; r--) result.push(matrix[r][left]);
        }
        solve(top + 1, bottom - 1, left + 1, right - 1);
    }
    solve(0, matrix.length - 1, 0, matrix[0].length - 1);
    return result;
};

