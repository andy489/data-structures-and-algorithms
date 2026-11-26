// https://leetcode.com/problems/k-radius-subarray-averages/

// Solution: Sliding Window — O(n) time, O(n) space
var getAverages = function(nums, k) {
    const n = nums.length, res = new Array(n).fill(-1);
    if (2*k+1 > n) return res;
    const prefix = new Array(n+1).fill(0);
    for (let i = 0; i < n; i++) prefix[i+1] = prefix[i] + nums[i];
    const d = 2*k+1;
    for (let i = k; i < n-k; i++) res[i] = Math.floor((prefix[i+k+1] - prefix[i-k]) / d);
    return res;
};
