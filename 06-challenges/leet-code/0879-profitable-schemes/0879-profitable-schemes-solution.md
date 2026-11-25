# 879. Profitable Schemes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/profitable-schemes/

---

## Solution: 2D DP — O(k * n * p) time, O(n * p) space

**Idea:** dp[j][p] = number of schemes using exactly j members with exactly p profit. For each crime, update dp. Clamp profit at minProfit (treat ">=minProfit" as one bucket).

**Algorithm:**
1. dp[0][0] = 1.
2. For each crime with group g and profit pr: reverse iterate j from n down to g, p from minProfit down to 0.
3. dp[j][min(p+pr, minProfit)] += dp[j-g][p].
4. Answer is sum of dp[j][minProfit] for all j.

**Complexity:**

| | |
|---|---|
| Time | O(k * n * p) |
| Space | O(n * p) |
