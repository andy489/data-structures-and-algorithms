// https://leetcode.com/problems/find-the-largest-almost-missing-integer/

var largestInteger = function(nums, k) {
    const n = nums.length;
    const count = new Map();
    for (let start = 0; start <= n - k; start++) {
        const seen = new Set(nums.slice(start, start + k));
        for (const v of seen) {
            count.set(v, (count.get(v) || 0) + 1);
        }
    }
    let ans = -1;
    for (const [v, c] of count) {
        if (c === 1) {
            ans = Math.max(ans, v);
        }
    }
    return ans;
};
