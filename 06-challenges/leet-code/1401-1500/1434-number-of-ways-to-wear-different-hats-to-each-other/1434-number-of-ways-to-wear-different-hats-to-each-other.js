// https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

var numberWays = function(hats) {
    const n = hats.length, MOD = 1000000007n;
    const hatPeople = new Map();
    for (let p = 0; p < n; p++)
        for (const h of hats[p]) {
            if (!hatPeople.has(h)) hatPeople.set(h, []);
            hatPeople.get(h).push(p);
        }
    const dp = new Array(1 << n).fill(0n); dp[0] = 1n;
    for (let h = 1; h <= 40; h++)
        for (let mask = (1<<n)-1; mask >= 0; mask--)
            for (const p of (hatPeople.get(h) || []))
                if (!(mask >> p & 1)) dp[mask|(1<<p)] = (dp[mask|(1<<p)] + dp[mask]) % MOD;
    return Number(dp[(1<<n)-1]);
};
