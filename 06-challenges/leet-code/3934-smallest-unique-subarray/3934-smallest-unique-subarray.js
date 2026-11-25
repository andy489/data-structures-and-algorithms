// https://leetcode.com/problems/smallest-unique-subarray/

var smallestUniqueSubarray = function(nums) {
    const n = nums.length;
    const MOD = (1n << 61n) - 1n;
    const BASE = 100003n;

    const mul = (a, b) => (a * b) % MOD;
    const add = (a, b) => (a + b) % MOD;
    const sub = (a, b) => ((a - b) % MOD + MOD) % MOD;

    const hasUnique = (k) => {
        let pw = 1n;
        for (let i = 0; i < k; i++) pw = mul(pw, BASE);
        let h = 0n;
        for (let i = 0; i < k; i++) h = add(mul(h, BASE), BigInt(nums[i] + 1));
        const freq = new Map();
        freq.set(h, 1);
        for (let i = k; i < n; i++) {
            h = sub(add(mul(h, BASE), BigInt(nums[i] + 1)), mul(pw, BigInt(nums[i - k] + 1)));
            freq.set(h, (freq.get(h) || 0) + 1);
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
