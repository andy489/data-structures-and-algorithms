// https://leetcode.com/problems/smallest-pair-with-different-frequencies/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallestPair = function(nums) {
    const freq = new Map();
    for (const n of nums) {
        freq.set(n, (freq.get(n) || 0) + 1);
    }
    const vals = [...new Set(nums)].sort((a, b) => a - b);
    for (let i = 0; i < vals.length; i++) {
        for (let j = i + 1; j < vals.length; j++) {
            if (freq.get(vals[i]) !== freq.get(vals[j])) {
                return [vals[i], vals[j]];
            }
        }
    }
    return [-1, -1];
};
