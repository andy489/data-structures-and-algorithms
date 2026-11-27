// https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function(nums) {
    const LIMIT = 200010;

    // Sieve of Eratosthenes
    const isComposite = new Uint8Array(LIMIT);
    isComposite[0] = 1;
    isComposite[1] = 1;
    for (let i = 2; i * i < LIMIT; i++) {
        if (!isComposite[i]) {
            for (let j = i * i; j < LIMIT; j += i) {
                isComposite[j] = 1;
            }
        }
    }

    // Build next prime lookup
    const nextPrime = new Int32Array(LIMIT);
    let cur = -1;
    for (let i = LIMIT - 1; i >= 0; i--) {
        if (!isComposite[i]) {
            cur = i;
        }
        nextPrime[i] = cur;
    }

    // Build next composite lookup
    const nextComposite = new Int32Array(LIMIT);
    cur = -1;
    for (let i = LIMIT - 1; i >= 0; i--) {
        if (isComposite[i]) {
            cur = i;
        }
        nextComposite[i] = cur;
    }

    let ops = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            ops += nextPrime[nums[i]] - nums[i];
        } else {
            ops += nextComposite[nums[i]] - nums[i];
        }
    }
    return ops;
};
