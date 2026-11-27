// https://leetcode.com/problems/count-non-adjacent-subsets-in-a-rooted-tree/
/**
 * @param {number[]} parent
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countNonAdjacentSubsets = function(parent, nums, k) {
    const MOD = 1_000_000_007n;
    const n = parent.length;
    const children = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) {
        children[parent[i]].push(i);
    }

    // dp[node][2][k] using BigInt for modular arithmetic
    const dp = Array.from({length: n}, () => [
        new Array(k).fill(0n),
        new Array(k).fill(0n)
    ]);

    function dfs(node) {
        const rem = nums[node] % k;
        dp[node][1][rem] = 1n;
        dp[node][0][0] = 1n;

        for (const child of children[node]) {
            dfs(child);
            const merged = [new Array(k).fill(0n), new Array(k).fill(0n)];
            for (let incN = 0; incN <= 1; incN++) {
                for (let remN = 0; remN < k; remN++) {
                    if (dp[node][incN][remN] === 0n) {
                        continue;
                    }
                    const val = dp[node][incN][remN];
                    for (let remC = 0; remC < k; remC++) {
                        const childWays = (dp[child][0][remC] + dp[child][1][remC]) % MOD;
                        const newRem = (remN + remC) % k;
                        merged[incN][newRem] = (merged[incN][newRem] + val * childWays) % MOD;
                        if (incN === 1) {
                            merged[incN][newRem] = (merged[incN][newRem] - val * dp[child][1][remC] % MOD + MOD) % MOD;
                        }
                    }
                }
            }
            dp[node][0] = merged[0];
            dp[node][1] = merged[1];
        }
    }

    dfs(0);
    const ans = (dp[0][0][0] + dp[0][1][0] - 1n + MOD) % MOD;
    return Number(ans);
};
