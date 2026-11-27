// https://leetcode.com/problems/count-the-number-of-winning-sequences/

/**
 * @param {string} s
 * @return {number}
 */
var countWinningSequences = function (s) {
    const MOD = 1_000_000_007n;
    const n = s.length;
    const charMap = { 'F': 0, 'W': 1, 'E': 2 };
    // delta[bob][alice]: +1 Bob wins, -1 Alice wins, 0 tie
    const delta = [[0, -1, 1], [1, 0, -1], [-1, 1, 0]];
    const offset = n;

    let dp = Array.from({ length: 3 }, () => new Array(2 * n + 1).fill(0n));
    const alice0 = charMap[s[0]];
    for (let c = 0; c < 3; c++) {
        dp[c][delta[c][alice0] + offset]++;
    }

    for (let i = 1; i < n; i++) {
        const alice = charMap[s[i]];
        const ndp = Array.from({ length: 3 }, () => new Array(2 * n + 1).fill(0n));
        for (let last = 0; last < 3; last++) {
            for (let sc = 0; sc <= 2 * n; sc++) {
                if (dp[last][sc] === 0n) {
                    continue;
                }
                for (let c = 0; c < 3; c++) {
                    if (c === last) {
                        continue;
                    }
                    const d = delta[c][alice];
                    const nsc = sc + d;
                    if (nsc >= 0 && nsc <= 2 * n) {
                        ndp[c][nsc] = (ndp[c][nsc] + dp[last][sc]) % MOD;
                    }
                }
            }
        }
        dp = ndp;
    }

    let result = 0n;
    for (let c = 0; c < 3; c++) {
        for (let sc = offset + 1; sc <= 2 * n; sc++) {
            result = (result + dp[c][sc]) % MOD;
        }
    }
    return Number(result);
};
