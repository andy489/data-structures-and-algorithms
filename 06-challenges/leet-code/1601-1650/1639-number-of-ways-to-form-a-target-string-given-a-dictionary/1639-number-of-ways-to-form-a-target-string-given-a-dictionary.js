// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

var numWays = function(words, target) {
    const MOD = 1_000_000_007n;
    const L = words[0].length, m = target.length;
    const cnt = Array.from({length: L}, () => new Array(26).fill(0));
    for (const w of words) {
        for (let k = 0; k < L; k++) {
            cnt[k][w.charCodeAt(k) - 97]++;
        }
    }
    const dp = new Array(m + 1).fill(0n);
    dp[0] = 1n;
    for (let k = 0; k < L; k++) {
        for (let i = Math.min(k, m - 1); i >= 0; i--) {
            const c = target.charCodeAt(i) - 97;
            dp[i + 1] = (dp[i + 1] + dp[i] * BigInt(cnt[k][c])) % MOD;
        }
    }
    return Number(dp[m]);
};
