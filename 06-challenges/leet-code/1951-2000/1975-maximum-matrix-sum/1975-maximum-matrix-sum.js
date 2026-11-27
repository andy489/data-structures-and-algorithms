// https://leetcode.com/problems/maximum-matrix-sum/

// Solution: Greedy — O(n^2) time, O(1) space
var maxMatrixSum = function(matrix) {
    let total = 0n;
    let minAbs = Infinity;
    let negCount = 0;
    for (const row of matrix) {
        for (const val of row) {
            total += BigInt(Math.abs(val));
            if (val < 0) negCount++;
            minAbs = Math.min(minAbs, Math.abs(val));
        }
    }
    if (negCount % 2 === 0) return Number(total);
    return Number(total) - 2 * minAbs;
};
