// https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/

var countSubMultisets = function(nums, l, r) {
    const MOD = 1_000_000_007n;
    const freq = new Map();
    for (const x of nums) {
        freq.set(x, (freq.get(x) || 0) + 1);
    }

    const zeroCount = freq.get(0) || 0;
    freq.delete(0);

    let dp = new Array(r + 1).fill(0n);
    dp[0] = 1n;

    for (const [v, c] of freq) {
        if (v > r) continue;
        const ndp = new Array(r + 1).fill(0n);
        for (let rem = 0; rem < v && rem <= r; rem++) {
            let windowSum = 0n;
            const positions = [];
            for (let p = rem; p <= r; p += v) positions.push(p);
            for (let t = 0; t < positions.length; t++) {
                const p = positions[t];
                windowSum = (windowSum + dp[p]) % MOD;
                if (t > c) {
                    windowSum = (windowSum - dp[positions[t - c - 1]] + MOD) % MOD;
                }
                ndp[p] = windowSum;
            }
        }
        dp = ndp;
    }

    let ans = 0n;
    for (let s = l; s <= r; s++) {
        ans = (ans + dp[s]) % MOD;
    }
    return Number(ans * BigInt(zeroCount + 1) % MOD);
};
