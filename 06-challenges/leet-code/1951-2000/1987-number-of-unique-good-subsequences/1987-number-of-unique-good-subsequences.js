// https://leetcode.com/problems/number-of-unique-good-subsequences/

// Solution: DP — O(n) time, O(1) space
var numberOfUniqueGoodSubsequences = function(binary) {
    const MOD = 1_000_000_007n;
    let ends1 = 0n, ends0 = 0n;
    let hasZero = false;
    for (const c of binary) {
        if (c === '1') {
            ends1 = (ends1 + ends0 + 1n) % MOD;
        } else {
            ends0 = (ends0 + ends1) % MOD;
            hasZero = true;
        }
    }
    return Number((ends1 + ends0 + (hasZero ? 1n : 0n)) % MOD);
};
