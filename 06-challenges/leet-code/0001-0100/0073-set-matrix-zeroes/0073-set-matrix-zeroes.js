// https://leetcode.com/problems/set-matrix-zeroes/

var setZeroes = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const zeroRows = new Set(), zeroCols = new Set();
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 0) {
                zeroRows.add(i);
                zeroCols.add(j);
            }
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (zeroRows.has(i) || zeroCols.has(j)) {
                matrix[i][j] = 0;
            }
        }
    }
};

// Solution 2: Constant Space — O(m·n) time, O(1) space
var setZeroes2 = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    let firstRowZero = matrix[0].some(v => v === 0);
    let firstColZero = matrix.some(row => row[0] === 0);
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][j] === 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    for (let i = 1; i < m; i++) {
        if (matrix[i][0] === 0) {
            for (let j = 1; j < n; j++) matrix[i][j] = 0;
        }
    }
    for (let j = 1; j < n; j++) {
        if (matrix[0][j] === 0) {
            for (let i = 1; i < m; i++) matrix[i][j] = 0;
        }
    }
    if (firstRowZero) {
        for (let j = 0; j < n; j++) matrix[0][j] = 0;
    }
    if (firstColZero) {
        for (let i = 0; i < m; i++) matrix[i][0] = 0;
    }
};
