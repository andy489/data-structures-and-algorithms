# 1140. Stone Game II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-ii/

---

## Solution: DP with Suffix Sums — O(n^2) time, O(n^2) space

**Idea:** `dp[i][m]` = maximum stones the **current player** can collect starting from index `i` with current `M = m`. Since both players play optimally, the current player maximizes their own take. The current player takes `x` piles (1 <= x <= 2M), gaining `suffix[i] - suffix[i+x]` minus what the opponent can get.

Equivalently: `dp[i][m] = max over x in [1..2m] of (suffix[i] - dp[i+x][max(m,x)])`.

If `i + 2*m >= n` (can take all remaining), `dp[i][m] = suffix[i]`.

**Algorithm:**
1. Compute suffix sums.
2. Fill `dp` bottom-up from right to left.
3. Return `dp[0][1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — O(n) states * O(n) transitions |
| Space | O(n^2) — dp table |
