// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/

/**
 * @param {string} s
 * @param {number} t
 * @return {number}
 */
var lengthAfterTransformations = function(s, t) {
    const MOD = 1_000_000_007n;
    const freq = new Array(26).fill(0n);
    for (const c of s) {
        freq[c.charCodeAt(0) - 97]++;
    }
    for (let step = 0; step < t; step++) {
        const newFreq = new Array(26).fill(0n);
        for (let i = 0; i < 25; i++) {
            newFreq[i + 1] = (newFreq[i + 1] + freq[i]) % MOD;
        }
        newFreq[0] = (newFreq[0] + freq[25]) % MOD;
        newFreq[1] = (newFreq[1] + freq[25]) % MOD;
        for (let i = 0; i < 26; i++) { freq[i] = newFreq[i]; }
    }
    let ans = 0n;
    for (const f of freq) { ans = (ans + f) % MOD; }
    return Number(ans);
};
