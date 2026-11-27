# 1510. Stone Game IV — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stone-game-iv/

---

## Solution: Dynamic Programming — O(n * sqrt(n)) time, O(n) space

**Idea:** `dp[i]` = `true` if the current player wins when there are `i` stones. The current player wins if there exists a perfect square `k^2 <= i` such that `dp[i - k^2]` is `false` (i.e., after removing `k^2` stones, the opponent is in a losing position).

**Algorithm:**
1. `dp[0] = false` (no moves available → current player loses).
2. For each `i` from 1 to `n`:
   - For each `k` such that `k^2 <= i`, if `dp[i - k^2] == false`, set `dp[i] = true` and break.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n * sqrt(n)) — for each of n states we check up to sqrt(n) squares |
| Space | O(n) — DP table |
