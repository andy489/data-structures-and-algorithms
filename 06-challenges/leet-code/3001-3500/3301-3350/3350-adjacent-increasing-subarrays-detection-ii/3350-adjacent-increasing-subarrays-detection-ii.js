// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/

// Solution: Precompute Ending/Starting Run Lengths — O(n) time, O(n) space
var maxIncreasingSubarrays = function(nums) {
    const n = nums.length;
    // inc[i] = length of strictly increasing run ending at i
    const inc = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            inc[i] = inc[i - 1] + 1;
        }
    }
    // startInc[i] = length of strictly increasing run starting at i
    const startInc = new Array(n).fill(1);
    for (let i = n - 2; i >= 0; i--) {
        if (nums[i + 1] > nums[i]) {
            startInc[i] = startInc[i + 1] + 1;
        }
    }
    let ans = 0;
    for (let m = 1; m < n; m++) {
        ans = Math.max(ans, Math.min(inc[m - 1], startInc[m]));
    }
    return ans;
};
