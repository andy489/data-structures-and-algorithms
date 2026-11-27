# 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

---

## Solution: 3D DP — O(n*m*k*m) time, O(n*m*k) space

**Idea:** dp[i][j][c] = #arrays of length i, last max=j, search cost=c. Transition: extend with values <= j (cost stays) or values > j (cost+1, new max).

**Algorithm:**
1. dp[1][j][1] = 1 for j in [1,m].
2. For length i, max j, cost c: extend with v <= j (cost stays): dp[i+1][j][c] += j * dp[i][j][c].
3. Extend with v > j (new max): for each v in (j,m]: dp[i+1][v][c+1] += dp[i][j][c].

**Complexity:**

| | |
|---|---|
| Time | O(n*m*k*m) |
| Space | O(n*m*k) |
