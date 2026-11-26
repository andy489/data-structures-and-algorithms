// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

// Solution: Simulation — O(n) time, O(1) space
var finalValueAfterOperations = function(operations) {
    return operations.reduce((x, op) => x + (op.includes('+') ? 1 : -1), 0);
};
