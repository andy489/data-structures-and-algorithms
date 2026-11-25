// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

var maxEqualRowsAfterFlips = function(matrix) {
    const freq = new Map();
    for (const row of matrix) {
        const flip = row[0];
        const key = row.map(v => v ^ flip).join('');
        freq.set(key, (freq.get(key)||0) + 1);
    }
    return Math.max(...freq.values());
};
