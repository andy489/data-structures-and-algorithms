// https://leetcode.com/problems/number-of-substrings-with-only-1s/

var numSub = function(s) {
    const MOD = 1_000_000_007n;
    let result = 0n, cur = 0;
    for (const c of s) {
        if (c === '1') {
            cur++;
            result += BigInt(cur);
        } else {
            cur = 0;
        }
    }
    return Number(result % MOD);
};
