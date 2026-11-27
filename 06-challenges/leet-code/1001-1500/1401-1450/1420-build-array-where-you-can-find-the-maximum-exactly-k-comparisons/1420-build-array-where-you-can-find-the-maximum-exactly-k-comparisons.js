// https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

var numOfArrays = function(n, m, k) {
    const MOD = 1000000007n;
    const dp = Array.from({length:n+1},()=>Array.from({length:m+1},()=>new Array(k+1).fill(0n)));
    for (let j = 1; j <= m; j++) dp[1][j][1] = 1n;
    for (let i = 1; i < n; i++)
        for (let j = 1; j <= m; j++)
            for (let c = 1; c <= k; c++) {
                if (!dp[i][j][c]) continue;
                dp[i+1][j][c] = (dp[i+1][j][c] + dp[i][j][c] * BigInt(j)) % MOD;
                for (let v = j+1; v <= m; v++)
                    dp[i+1][v][c+1] = (dp[i+1][v][c+1] + dp[i][j][c]) % MOD;
            }
    let ans = 0n;
    for (let j = 1; j <= m; j++) ans = (ans + dp[n][j][k]) % MOD;
    return Number(ans);
};
