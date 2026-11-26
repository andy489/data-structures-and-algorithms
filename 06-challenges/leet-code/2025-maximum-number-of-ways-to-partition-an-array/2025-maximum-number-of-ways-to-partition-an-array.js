// https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

// Solution: Prefix Sums + HashMap — O(n) time, O(n) space
var waysToPartition = function(nums, k) {
    const n = nums.length;
    const prefix = new Array(n).fill(0);
    prefix[0] = nums[0];
    for (let i = 1; i < n; i++) prefix[i] = prefix[i-1] + nums[i];
    const total = prefix[n-1];
    let res = 0;
    if (total % 2 === 0) {
        for (let i = 0; i < n-1; i++) if (prefix[i] === total / 2) res++;
    }
    const left = new Map(), right = new Map();
    for (let i = 1; i < n; i++) right.set(prefix[i-1], (right.get(prefix[i-1]) || 0) + 1);
    for (let j = 0; j < n; j++) {
        const newTotal = total - nums[j] + k;
        if (newTotal % 2 === 0) {
            const half = newTotal / 2, diff = k - nums[j];
            const cnt = (left.get(half - diff) || 0) + (right.get(half) || 0);
            res = Math.max(res, cnt);
        }
        right.set(prefix[j], (right.get(prefix[j]) || 1) - 1);
        if (j < n - 1) left.set(prefix[j], (left.get(prefix[j]) || 0) + 1);
    }
    return res;
};
