// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
var maxSubarrayLength = function(nums, k) {
    const freq = new Map();
    let left = 0;
    let maxLen = 0;
    for (let right = 0; right < nums.length; right++) {
        const x = nums[right];
        freq.set(x, (freq.get(x) || 0) + 1);
        while (freq.get(x) > k) {
            const l = nums[left];
            freq.set(l, freq.get(l) - 1);
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
};
