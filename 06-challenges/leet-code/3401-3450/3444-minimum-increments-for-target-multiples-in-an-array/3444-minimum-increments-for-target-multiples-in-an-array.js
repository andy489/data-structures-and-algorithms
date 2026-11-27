// https://leetcode.com/problems/minimum-increments-for-target-multiples-in-an-array/
var minimumIncrements = function(nums, target) {
    const t = target.length;
    const masks = 1 << t;

    const gcd = (a, b) => b === 0n ? a : gcd(b, a % b);
    const lcm = (a, b) => {
        const ba = BigInt(a), bb = BigInt(b);
        return ba / gcd(ba, bb) * bb;
    };

    const lcms = new Array(masks).fill(1n);
    for (let mask = 1; mask < masks; mask++) {
        const bit = (mask & -mask).toString(2).length - 1;
        lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit]);
    }

    const INF = BigInt(Number.MAX_SAFE_INTEGER);
    let dp = new Array(masks).fill(INF);
    dp[0] = 0n;

    for (const num of nums) {
        const ndp = [...dp];
        for (let prev = 0; prev < masks; prev++) {
            if (dp[prev] === INF) {
                continue;
            }
            for (let add = 1; add < masks; add++) {
                if (prev & add) {
                    continue;
                }
                const lc = lcms[add];
                const rem = BigInt(num) % lc;
                const cost = rem === 0n ? 0n : lc - rem;
                const nxt = prev | add;
                const cand = dp[prev] + cost;
                if (cand < ndp[nxt]) {
                    ndp[nxt] = cand;
                }
            }
        }
        dp = ndp;
    }

    return Number(dp[masks - 1]);
};
