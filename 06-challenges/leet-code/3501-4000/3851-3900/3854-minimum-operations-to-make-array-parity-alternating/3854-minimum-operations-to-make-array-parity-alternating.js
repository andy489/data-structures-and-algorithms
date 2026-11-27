// https://leetcode.com/problems/minimum-operations-to-make-array-parity-alternating/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minOperations = function(nums) {
    const n = nums.length;
    let mismatch0 = 0, mismatch1 = 0;
    for (let i = 0; i < n; i++) {
        const parity = Math.abs(nums[i]) % 2;
        if (parity !== i % 2) mismatch0++;
        if (parity !== (1 - i % 2)) mismatch1++;
    }
    const minOps = Math.min(mismatch0, mismatch1);
    const p = mismatch0 <= mismatch1 ? 0 : 1;

    let lo = Infinity, hi = -Infinity;
    for (let i = 0; i < n; i++) {
        const want = p === 0 ? i % 2 : 1 - i % 2;
        const parity = Math.abs(nums[i]) % 2;
        const v = nums[i];
        if (parity !== want) {
            lo = Math.min(lo, v - 1, v + 1);
            hi = Math.max(hi, v - 1, v + 1);
        } else {
            lo = Math.min(lo, v);
            hi = Math.max(hi, v);
        }
    }
    return [minOps, hi - lo];
};
