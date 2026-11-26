// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

// Solution: Flatten, Sort, Median — O(mn log mn) time, O(mn) space
var minOperations = function(grid, x) {
    const vals = grid.flat().sort((a, b) => a - b);
    const rem = vals[0] % x;
    if (vals.some(v => v % x !== rem)) return -1;
    const median = vals[Math.floor(vals.length / 2)];
    return vals.reduce((ops, v) => ops + Math.abs(v - median) / x, 0);
};
