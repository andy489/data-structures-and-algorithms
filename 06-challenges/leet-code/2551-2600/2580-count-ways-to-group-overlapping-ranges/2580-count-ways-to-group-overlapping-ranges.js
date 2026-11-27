// https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/

/**
 * @param {number[][]} ranges
 * @return {number}
 */
var countWays = function(ranges) {
    const MOD = 1_000_000_007n;
    ranges.sort((a, b) => a[0] - b[0]);
    let components = 0;
    let maxEnd = -1;
    for (const [start, end] of ranges) {
        if (start > maxEnd) {
            components++;
        }
        maxEnd = Math.max(maxEnd, end);
    }
    let result = 1n;
    for (let i = 0; i < components; i++) {
        result = result * 2n % MOD;
    }
    return Number(result);
};
