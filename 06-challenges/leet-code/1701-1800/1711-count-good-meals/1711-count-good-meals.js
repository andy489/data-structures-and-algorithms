// https://leetcode.com/problems/count-good-meals/

var countPairs = function(deliciousness) {
    const MOD = 1_000_000_007n;
    const freq = new Map();
    let count = 0n;
    for (const d of deliciousness) {
        for (let i = 0; i <= 21; i++) {
            const p = 1 << i;
            const complement = p - d;
            count = (count + BigInt(freq.get(complement) || 0)) % MOD;
        }
        freq.set(d, (freq.get(d) || 0) + 1);
    }
    return Number(count);
};
