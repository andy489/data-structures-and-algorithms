// https://leetcode.com/problems/count-number-of-homogenous-substrings/

var countHomogenous = function(s) {
    const MOD = 1_000_000_007n;
    let ans = 0n;
    let i = 0;
    while (i < s.length) {
        let j = i;
        while (j < s.length && s[j] === s[i]) j++;
        const k = BigInt(j - i);
        ans = (ans + k * (k + 1n) / 2n) % MOD;
        i = j;
    }
    return Number(ans);
};
