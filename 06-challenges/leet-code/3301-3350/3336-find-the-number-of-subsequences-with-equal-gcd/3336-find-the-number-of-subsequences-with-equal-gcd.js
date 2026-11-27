// https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

/**
 * @param {number[]} nums
 * @return {number}
 */
var subsequencePairCount = function(nums) {
    const MOD = 1_000_000_007n;
    const maxVal = 201;

    function gcd(a, b) {
        while (b) { [a, b] = [b, a % b]; }
        return a;
    }

    let dp = Array.from({length: maxVal}, () => new Array(maxVal).fill(0n));
    dp[0][0] = 1n;

    for (const x of nums) {
        const newDp = Array.from({length: maxVal}, () => new Array(maxVal).fill(0n));
        for (let g1 = 0; g1 < maxVal; g1++) {
            for (let g2 = 0; g2 < maxVal; g2++) {
                if (dp[g1][g2] === 0n) { continue; }
                const val = dp[g1][g2];
                // Skip x
                newDp[g1][g2] = (newDp[g1][g2] + val) % MOD;
                // Add x to seq1
                const ng1 = g1 === 0 ? x : gcd(g1, x);
                newDp[ng1][g2] = (newDp[ng1][g2] + val) % MOD;
                // Add x to seq2
                const ng2 = g2 === 0 ? x : gcd(g2, x);
                newDp[g1][ng2] = (newDp[g1][ng2] + val) % MOD;
            }
        }
        dp = newDp;
    }

    let ans = 0n;
    for (let g = 1; g < maxVal; g++) {
        ans = (ans + dp[g][g]) % MOD;
    }
    return Number(ans);
};
