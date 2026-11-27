# 629. K Inverse Pairs Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/k-inverse-pairs-array/

---

## Solution: DP with Sliding Window — O(n·k) time, O(k) space

**Idea:** Let `dp[i][j]` = number of permutations of [1..i] with exactly j inverse pairs. When inserting i, it can be placed at any of i positions, adding 0 to i-1 new inverse pairs. The transition is: `dp[i][j] = sum(dp[i-1][j-t]) for t=0..min(j,i-1)`. Use prefix sums to compute this in O(1) per cell.

**Algorithm:**
1. `dp[0] = [1, 0, 0, ...]`.
2. For each i from 1 to n, compute new row using prefix sum of previous row.
3. `dp[i][j] = prefix[j] - prefix[j-i]` (clamped, mod 10^9+7).

**Complexity:**

| | |
|---|---|
| Time | O(n·k) — DP table |
| Space | O(k) — two 1D arrays |
