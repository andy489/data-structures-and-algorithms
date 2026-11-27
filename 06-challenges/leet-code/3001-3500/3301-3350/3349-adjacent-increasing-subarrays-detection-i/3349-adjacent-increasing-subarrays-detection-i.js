// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/

// Solution: Precompute Run Lengths — O(n) time, O(n) space
var hasIncreasingSubarrays = function(nums, k) {
    const n = nums.length;
    const inc = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            inc[i] = inc[i - 1] + 1;
        }
    }
    for (let a = 0; a + 2 * k <= n; a++) {
        if (inc[a + k - 1] >= k && inc[a + 2 * k - 1] >= k) {
            return true;
        }
    }
    return false;
};
