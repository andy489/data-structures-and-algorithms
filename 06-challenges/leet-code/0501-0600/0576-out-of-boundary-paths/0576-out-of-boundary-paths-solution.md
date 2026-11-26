# Solution: Out of Boundary Paths

## Approach
DP where `dp[i][j]` is the number of ways to reach cell `(i, j)` with exactly `k` moves. Iterate over moves from 1 to `maxMove`, accumulate boundary exits into the answer modulo 10^9+7.

**Time:** O(maxMove * m * n) | **Space:** O(m * n)
