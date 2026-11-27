// https://leetcode.com/problems/range-addition-ii/
var maxCount = function(m, n, ops) {
    if (ops.length === 0) {
        return m * n;
    }
    let minRow = m, minCol = n;
    for (const [a, b] of ops) {
        minRow = Math.min(minRow, a);
        minCol = Math.min(minCol, b);
    }
    return minRow * minCol;
};
