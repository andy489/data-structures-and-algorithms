// https://leetcode.com/problems/special-positions-in-a-binary-matrix/

var numSpecial = function(mat) {
    const m = mat.length, n = mat[0].length;
    const rowSum = mat.map(row => row.reduce((a, b) => a + b, 0));
    const colSum = Array.from({length: n}, (_, j) => mat.reduce((a, row) => a + row[j], 0));
    let count = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 1 && rowSum[i] === 1 && colSum[j] === 1) count++;
        }
    }
    return count;
};
