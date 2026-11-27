// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
/**
 * @param {number[]} nums
 * @param {number} value
 * @return {number}
 */
var findSmallestInteger = function(nums, value) {
    const residueCount = new Map();
    for (const num of nums) {
        const r = ((num % value) + value) % value;
        residueCount.set(r, (residueCount.get(r) || 0) + 1);
    }
    let mex = 0;
    while (true) {
        const r = mex % value;
        const available = residueCount.get(r) || 0;
        if (available === 0) {
            return mex;
        }
        residueCount.set(r, available - 1);
        mex++;
    }
};
