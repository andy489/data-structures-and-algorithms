// https://leetcode.com/problems/sum-of-good-subsequences/

// Solution: DP with Hash Map (Count + Sum Tracking) — O(n) time, O(n) space
var sumOfGoodSubsequences = function(nums) {
    const MOD = 1_000_000_007n;
    const cnt = new Map();
    const total = new Map();

    for (const v of nums) {
        const bv = BigInt(v);
        const newCnt = ((cnt.get(v - 1) ?? 0n) + (cnt.get(v + 1) ?? 0n) + 1n) % MOD;
        const newSum = ((total.get(v - 1) ?? 0n) + (total.get(v + 1) ?? 0n) + bv * newCnt) % MOD;
        cnt.set(v, ((cnt.get(v) ?? 0n) + newCnt) % MOD);
        total.set(v, ((total.get(v) ?? 0n) + newSum) % MOD);
    }

    let ans = 0n;
    for (const s of total.values()) {
        ans = (ans + s) % MOD;
    }
    return Number(ans);
};
