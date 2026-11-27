// https://leetcode.com/problems/count-all-possible-routes/

var countRoutes = function(locations, start, finish, fuel) {
    const MOD = 1_000_000_007;
    const n = locations.length;
    const memo = Array.from({length: n}, () => new Array(fuel + 1).fill(-1));

    const dp = (cur, remaining) => {
        if (remaining < 0) {
            return 0;
        }
        if (memo[cur][remaining] !== -1) {
            return memo[cur][remaining];
        }
        let res = cur === finish ? 1 : 0;
        for (let next = 0; next < n; next++) {
            if (next !== cur) {
                const cost = Math.abs(locations[next] - locations[cur]);
                if (remaining >= cost) {
                    res = (res + dp(next, remaining - cost)) % MOD;
                }
            }
        }
        memo[cur][remaining] = res;
        return res;
    };

    return dp(start, fuel);
};
