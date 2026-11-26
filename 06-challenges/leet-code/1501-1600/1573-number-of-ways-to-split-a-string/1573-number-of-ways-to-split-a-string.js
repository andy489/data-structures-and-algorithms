// https://leetcode.com/problems/number-of-ways-to-split-a-string/

var numWays = function(s) {
    const MOD = 1_000_000_007n;
    const ones = s.split('').filter(c => c === '1').length;
    const n = s.length;
    if (ones % 3 !== 0) {
        return 0;
    }
    if (ones === 0) {
        return Number(BigInt(n - 1) * BigInt(n - 2) / 2n % MOD);
    }
    const third = ones / 3;
    let gap1 = 0n, gap2 = 0n, cnt = 0;
    for (const c of s) {
        if (c === '1') {
            cnt++;
        }
        if (cnt === third) {
            gap1++;
        } else if (cnt === 2 * third) {
            gap2++;
        }
    }
    return Number(gap1 * gap2 % MOD);
};
