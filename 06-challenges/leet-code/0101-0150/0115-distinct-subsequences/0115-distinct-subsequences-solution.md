# 115. Distinct Subsequences — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/distinct-subsequences/

---

## Solution 1: 2D Dynamic Programming — O(m·n) time, O(m·n) space

**Idea:** Let `dp[i][j]` = number of ways to form `t[0..i-1]` using `s[0..j-1]`. At each cell we decide: always include the ways that skip `s[j-1]` (i.e. `dp[i][j-1]`), and if `s[j-1] == t[i-1]` also add the ways that used both (`dp[i-1][j-1]`).

**Algorithm:**
1. Create `dp[m+1][n+1]` where `m = t.length`, `n = s.length`.
2. Base case: `dp[0][j] = 1` for all `j` — empty `t` is a subsequence of any prefix of `s` in exactly one way.
3. For `i` from 1 to `m`, `j` from 1 to `n`:
   - `dp[i][j] = dp[i][j-1]` (skip `s[j-1]`)
   - If `s[j-1] == t[i-1]`: `dp[i][j] += dp[i-1][j-1]`
4. Return `dp[m][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — fill every cell of the table |
| Space | O(m·n) — the full DP table |

---

## Solution 2: 1D DP (Space-Optimised) — O(m·n) time, O(m) space

**Idea:** Each row of the 2D table depends only on the previous row. Keeping a single 1D array of length `m+1` (indexed by `t`) and iterating `s` right-to-left avoids overwriting values we still need.

**Algorithm:**
1. Create `dp[m+1]` initialised to 0; set `dp[0] = 1`.
2. For each character `c` in `s` (left to right):
   - Iterate `i` from `m` down to 1:
     - If `c == t[i-1]`: `dp[i] += dp[i-1]`.
3. Return `dp[m]`.

**Why right-to-left:** When we update `dp[i]` we need the old `dp[i-1]` (from before processing this character of `s`). Iterating downward ensures we read the old value before updating it.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — same recurrence, different memory layout |
| Space | O(m) — single array of length `t.length + 1` |
