// https://leetcode.com/problems/count-nice-pairs-in-an-array/

var countNicePairs = function(nums) {
    const MOD = 1000000007n;
    const rev = x => Number(String(x).split('').reverse().join(''));
    const freq = new Map();
    for (const x of nums) {
        const key = x - rev(x);
        freq.set(key, (freq.get(key) || 0n) + 1n);
    }
    let ans = 0n;
    for (const c of freq.values()) {
        ans = (ans + c * (c - 1n) / 2n) % MOD;
    }
    return Number(ans);
};
