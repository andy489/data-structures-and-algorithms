// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

var maxSumOfThreeSubarrays = function(nums, k) {
    const n = nums.length, m = n - k + 1;
    const sums = new Array(m);
    let w = nums.slice(0, k).reduce((a, b) => a + b, 0);
    sums[0] = w;
    for (let i = 1; i < m; i++) {
        w += nums[i + k - 1] - nums[i - 1];
        sums[i] = w;
    }
    const left = new Array(m);
    let best = 0;
    for (let i = 0; i < m; i++) {
        if (sums[i] > sums[best]) best = i;
        left[i] = best;
    }
    const right = new Array(m);
    best = m - 1;
    for (let i = m - 1; i >= 0; i--) {
        if (sums[i] >= sums[best]) best = i;
        right[i] = best;
    }
    let result = [-1, -1, -1], maxSum = 0;
    for (let mid = k; mid < m - k; mid++) {
        const l = left[mid - k], r = right[mid + k];
        const total = sums[l] + sums[mid] + sums[r];
        if (total > maxSum) { maxSum = total; result = [l, mid, r]; }
    }
    return result;
};
