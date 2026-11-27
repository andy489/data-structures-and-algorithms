// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/

var minimumSubarrayLength = function(nums, k) {
    let minLen = Infinity;
    for (let i = 0; i < nums.length; i++) {
        let or = 0;
        for (let j = i; j < nums.length; j++) {
            or |= nums[j];
            if (or >= k) { minLen = Math.min(minLen, j-i+1); break; }
        }
    }
    return minLen === Infinity ? -1 : minLen;
};
