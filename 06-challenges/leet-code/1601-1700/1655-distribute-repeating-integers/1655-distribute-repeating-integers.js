// https://leetcode.com/problems/distribute-repeating-integers/

var canDistribute = function(nums, quantity) {
    const countMap = new Map();
    for (const x of nums) {
        countMap.set(x, (countMap.get(x) || 0) + 1);
    }
    const freqs = [...countMap.values()].sort((a, b) => a - b);
    const m = quantity.length;
    const total = 1 << m;
    const need = new Int32Array(total);
    for (let mask = 1; mask < total; mask++) {
        for (let j = 0; j < m; j++) {
            if ((mask >> j) & 1) {
                need[mask] = need[mask ^ (1 << j)] + quantity[j];
                break;
            }
        }
    }
    const dp = new Uint8Array(total);
    dp[0] = 1;
    for (const f of freqs) {
        for (let s = total - 1; s >= 0; s--) {
            if (!dp[s]) {
                continue;
            }
            const complement = (total - 1) ^ s;
            for (let t = complement; t > 0; t = (t - 1) & complement) {
                if (need[t] <= f) {
                    dp[s | t] = 1;
                }
            }
        }
    }
    return dp[total - 1] === 1;
};
