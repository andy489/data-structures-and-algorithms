// https://leetcode.com/problems/convert-1d-array-into-2d-array/

// Solution: Reshape — O(m*n) time, O(1) extra space
var construct2DArray = function(original, m, n) {
    if (original.length !== m * n) return [];
    const res = [];
    for (let i = 0; i < m; i++) res.push(original.slice(i * n, (i + 1) * n));
    return res;
};
