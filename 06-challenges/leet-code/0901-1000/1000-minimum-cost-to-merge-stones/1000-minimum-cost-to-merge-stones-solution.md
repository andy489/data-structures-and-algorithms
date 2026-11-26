# 1000. Minimum Cost to Merge Stones — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-merge-stones/

---

## Solution: Interval DP — O(n³/k) time, O(n²) space

**Idea:** `dp[i][j]` = min cost to merge stones[i..j] into as few piles as possible. Merging n piles into 1 is only possible if `(n-1) % (k-1) == 0`.

**Algorithm:**
1. Feasibility check: `(n-1) % (k-1) != 0` → return -1.
2. DP with prefix sums.
3. For each interval length, try all split points at step k-1.

**Complexity:**

| | |
|---|---|
| Time | O(n³/k) |
| Space | O(n²) |
