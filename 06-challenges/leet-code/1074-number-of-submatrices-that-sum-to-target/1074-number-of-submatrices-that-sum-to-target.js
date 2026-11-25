// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

var numSubmatrixSumTarget = function(matrix, target) {
    const m = matrix.length, n = matrix[0].length;
    let count = 0;
    for (let r1 = 0; r1 < m; r1++) {
        const colSum = new Array(n).fill(0);
        for (let r2 = r1; r2 < m; r2++) {
            for (let c = 0; c < n; c++) colSum[c] += matrix[r2][c];
            const prefixCount = new Map([[0, 1]]);
            let prefix = 0;
            for (const s of colSum) {
                prefix += s;
                count += (prefixCount.get(prefix - target) || 0);
                prefixCount.set(prefix, (prefixCount.get(prefix)||0)+1);
            }
        }
    }
    return count;
};
