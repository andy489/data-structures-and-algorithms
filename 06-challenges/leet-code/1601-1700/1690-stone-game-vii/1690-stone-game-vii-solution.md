# 1690. Stone Game VII — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-vii/

---

## Solution: Interval DP — O(n^2) time, O(n^2) space

**Idea:** `dp[l][r]` = maximum score difference the current player can achieve over their opponent on the subarray `stones[l..r]`. The current player can remove left (scoring `sum[l+1..r]`) or remove right (scoring `sum[l..r-1]`). The opponent then plays optimally on the remaining subarray.

**Algorithm:**
1. Compute prefix sums for range sum queries.
2. `dp[l][r] = max(sum(l+1,r) - dp[l+1][r], sum(l,r-1) - dp[l][r-1])`.
3. Fill by increasing interval length.
4. Return `dp[0][n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n^2) |
