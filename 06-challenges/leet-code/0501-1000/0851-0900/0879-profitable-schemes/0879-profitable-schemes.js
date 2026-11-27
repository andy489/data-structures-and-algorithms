// https://leetcode.com/problems/profitable-schemes/

var profitableSchemes = function(n, minProfit, group, profit) {
    const MOD = 1000000007;
    const dp = Array.from({length: n + 1}, () => new Array(minProfit + 1).fill(0));
    dp[0][0] = 1;
    for (let k = 0; k < group.length; k++) {
        const g = group[k], pr = profit[k];
        for (let j = n; j >= g; j--) {
            for (let p = minProfit; p >= 0; p--) {
                const np = Math.min(p + pr, minProfit);
                dp[j][np] = (dp[j][np] + dp[j - g][p]) % MOD;
            }
        }
    }
    return dp.reduce((s, row) => (s + row[minProfit]) % MOD, 0);
};
