// https://leetcode.com/problems/find-the-original-typed-string-ii/

/**
 * @param {string} word
 * @param {number} k
 * @return {number}
 */
var possibleStringCount = function(word, k) {
    const MOD = 1_000_000_007n;
    // Build runs
    const runs = [];
    let i = 0;
    while (i < word.length) {
        let j = i;
        while (j < word.length && word[j] === word[i]) j++;
        runs.push(j - i);
        i = j;
    }
    const m = runs.length;
    // Total = product of all run lengths
    let total = 1n;
    for (const r of runs) {
        total = total * BigInt(r) % MOD;
    }
    if (k <= m) {
        return Number(total);
    }
    // Count strings with length in [m, k-1]
    const maxLen = k - 1;
    let dp = new Array(maxLen + 1).fill(0n);
    dp[0] = 1n;
    for (const runLen of runs) {
        const newDp = new Array(maxLen + 1).fill(0n);
        const prefix = new Array(maxLen + 2).fill(0n);
        for (let j = 0; j <= maxLen; j++) {
            prefix[j + 1] = (prefix[j] + dp[j]) % MOD;
        }
        for (let j = 1; j <= maxLen; j++) {
            const lo = Math.max(0, j - runLen);
            const hi = j - 1;
            newDp[j] = (prefix[hi + 1] - prefix[lo] + MOD) % MOD;
        }
        dp = newDp;
    }
    let bad = 0n;
    for (let j = m; j <= maxLen; j++) {
        bad = (bad + dp[j]) % MOD;
    }
    return Number((total - bad + MOD) % MOD);
};
