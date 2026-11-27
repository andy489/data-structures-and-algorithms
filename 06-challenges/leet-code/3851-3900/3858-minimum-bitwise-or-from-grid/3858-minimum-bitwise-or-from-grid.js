// https://leetcode.com/problems/minimum-bitwise-or-from-grid/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var minBitwiseOR = function(grid) {
    let reachable = new Set([0]);
    for (const row of grid) {
        const next = new Set();
        for (const v of reachable) {
            for (const x of row) {
                next.add(v | x);
            }
        }
        reachable = next;
    }
    return Math.min(...reachable);
};
