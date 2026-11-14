# 72. Edit Distance — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/edit-distance/

---

## Solution: 2D DP — O(m·n) time, O(m·n) space

**Idea:** `dp[i][j]` = minimum edit distance between `word1[0..i-1]` and `word2[0..j-1]`. Base cases: converting an empty string to/from a length-k string costs k. For each cell: if characters match, carry the diagonal; otherwise take the minimum of insert (`dp[i][j-1]`), delete (`dp[i-1][j]`), and replace (`dp[i-1][j-1]`), plus 1.

**Algorithm:**
1. Create `dp[m+1][n+1]`; set `dp[i][0] = i`, `dp[0][j] = j`.
2. For each `i` from `1` to `m`, each `j` from `1` to `n`:
   - If `word1[i-1] == word2[j-1]`: `dp[i][j] = dp[i-1][j-1]`
   - Else: `dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])`
3. Return `dp[m][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — fill every cell once |
| Space | O(m·n) — DP table |

---

## Solution 2: Space-Optimized DP — O(m·n) time, O(n) space

**Idea:** Each row of the DP table only depends on the current row and the previous row. Keep a single 1D array `dp[n+1]` and a `prev` variable to hold the diagonal value before overwriting.

**Algorithm:**
1. Initialize `dp[j] = j` for `j` from `0` to `n`.
2. For each `i` from `1` to `m`:
   - `prev = dp[0]`; `dp[0] = i`
   - For each `j` from `1` to `n`:
     - `temp = dp[j]`
     - If `word1[i-1] == word2[j-1]`: `dp[j] = prev`
     - Else: `dp[j] = 1 + min(prev, dp[j], dp[j-1])`
     - `prev = temp`
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — same recurrence |
| Space | O(n) — single row |
