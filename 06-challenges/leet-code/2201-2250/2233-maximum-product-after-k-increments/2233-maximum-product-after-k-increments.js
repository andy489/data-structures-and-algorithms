// https://leetcode.com/problems/maximum-product-after-k-increments/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumProduct = function(nums, k) {
    const MOD = 1_000_000_007n;
    // Min-heap using sorted array approach (small n, k up to 1e5)
    nums.sort((a, b) => a - b);
    for (let i = 0; i < k; i++) {
        nums[0]++;
        // Bubble up the incremented element
        let j = 0;
        while (j + 1 < nums.length && nums[j] > nums[j + 1]) {
            [nums[j], nums[j + 1]] = [nums[j + 1], nums[j]];
            j++;
        }
    }
    let product = 1n;
    for (const x of nums) {
        product = (product * BigInt(x)) % MOD;
    }
    return Number(product);
};
