// https://leetcode.com/problems/minimum-positive-sum-subarray/

// Solution: Prefix Sum + Brute Force — O(n * (r - l + 1)) time, O(n) space
var minimumSumSubarray = function(nums, l, r) {
    const n = nums.length;
    const pre = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        pre[i + 1] = pre[i] + nums[i];
    }
    let ans = Infinity;
    for (let k = l; k <= r; k++) {
        for (let i = 0; i <= n - k; i++) {
            const s = pre[i + k] - pre[i];
            if (s > 0) {
                ans = Math.min(ans, s);
            }
        }
    }
    return ans === Infinity ? -1 : ans;
};
