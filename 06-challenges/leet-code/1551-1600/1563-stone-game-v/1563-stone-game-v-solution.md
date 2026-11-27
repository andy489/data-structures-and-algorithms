# 1563. Stone Game V — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stone-game-v/

---

## Solution: Interval DP — O(n^3) time, O(n^2) space

**Idea:** Use interval DP where `dp[i][j]` is the maximum score Alice can get from subarray `stoneValue[i..j]`. For each split point `k`, if the left sum is smaller, Alice gets left sum plus the best play on the left. If right sum is smaller, Alice gets right sum plus best play on right. If equal, Alice chooses whichever gives more.

**Algorithm:**
1. Compute prefix sums for O(1) range sum queries.
2. Fill `dp[i][j]` for all intervals of increasing length.
3. For each interval `[i, j]`, try all split points `k` from `i` to `j-1`.
4. Return `dp[0][n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) — three nested loops over the intervals |
| Space | O(n^2) — the DP table |
