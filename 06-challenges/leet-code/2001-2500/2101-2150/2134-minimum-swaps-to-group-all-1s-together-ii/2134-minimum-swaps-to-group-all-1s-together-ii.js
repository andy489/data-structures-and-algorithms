// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
var minSwaps = function(nums) {
    const n = nums.length;
    const k = nums.reduce((a, b) => a + b, 0);
    if (k === 0) return 0;
    let windowOnes = nums.slice(0, k).reduce((a, b) => a + b, 0);
    let maxOnes = windowOnes;
    for (let i = 1; i < n; i++) {
        windowOnes += nums[(i + k - 1) % n] - nums[i - 1];
        maxOnes = Math.max(maxOnes, windowOnes);
    }
    return k - maxOnes;
};
