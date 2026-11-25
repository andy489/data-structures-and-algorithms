// https://leetcode.com/problems/smallest-unique-subarray/

var smallestUniqueSubarray = function(nums) {
    const n = nums.length;
    const MOD = (1n << 61n) - 1n;
    const BASE = 131n;

    const mul = (a, b) => (a * b) % MOD;

    const hasUnique = (k) => {
        const pw = new Array(k + 1).fill(1n);
        for (let i = 1; i <= k; i++) pw[i] = mul(pw[i - 1], BASE);
        const h = new Array(n + 1).fill(0n);
        for (let i = 0; i < n; i++) h[i + 1] = (mul(h[i], BASE) ^ BigInt(nums[i])) % MOD;
        const freq = new Map();
        for (let i = 0; i + k <= n; i++) {
            const key = (h[i + k] ^ mul(h[i], pw[k])) % MOD;
            freq.set(key, (freq.get(key) || 0) + 1);
        }
        for (const cnt of freq.values()) if (cnt === 1) return true;
        return false;
    };

    let lo = 1, hi = n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (hasUnique(mid)) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
