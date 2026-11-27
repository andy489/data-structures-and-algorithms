// https://leetcode.com/problems/find-the-smallest-balanced-index/

/**
 * @param {number[]} nums
 * @return {number}
 */
var smallestBalancedIndex = function(nums) {
    const n = nums.length;
    const total = nums.reduce((a, b) => a + b, 0);

    // Build suffix products with overflow guard using BigInt
    const sufProd = new Array(n + 1).fill(0n);
    sufProd[n] = 1n;
    const bigTotal = BigInt(total);
    for (let i = n - 1; i >= 0; i--) {
        sufProd[i] = sufProd[i + 1] * BigInt(nums[i]);
        if (sufProd[i] > bigTotal + 1n) {
            sufProd[i] = bigTotal + 1n; // cap
        }
    }

    let leftSum = 0n;
    for (let i = 0; i < n; i++) {
        if (leftSum === sufProd[i + 1]) {
            return i;
        }
        leftSum += BigInt(nums[i]);
    }
    return -1;
};
