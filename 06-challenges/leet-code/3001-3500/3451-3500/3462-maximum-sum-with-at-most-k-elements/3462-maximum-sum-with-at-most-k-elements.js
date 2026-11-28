// https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/

var maxSum = function(grid, limits, k) {
    const candidates = [];
    for (let i = 0; i < grid.length; i++) {
        const sorted = [...grid[i]].sort((a, b) => b - a);
        for (let j = 0; j < limits[i]; j++) {
            candidates.push(sorted[j]);
        }
    }
    candidates.sort((a, b) => b - a);
    let sum = 0;
    for (let i = 0; i < k; i++) {
        sum += candidates[i];
    }
    return sum;
};
