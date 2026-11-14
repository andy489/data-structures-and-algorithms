# 97. Interleaving String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/interleaving-string/

---

## Solution: 2D Dynamic Programming — O(m·n) time, O(m·n) space

**Idea:** `dp[i][j]` = `true` if the first `i` characters of `s1` and the first `j` characters of `s2` can together form the first `i+j` characters of `s3`. A cell is `true` if we can extend a valid state by matching either `s1[i-1]` (from `dp[i-1][j]`) or `s2[j-1]` (from `dp[i][j-1]`) against `s3[i+j-1]`.

**Algorithm:**
1. If `s1.length + s2.length != s3.length`, return `false`.
2. Initialize `dp[0][0] = true`.
3. Fill first row: `dp[0][j] = dp[0][j-1] && s2[j-1] == s3[j-1]`.
4. Fill first column: `dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1]`.
5. For each `i, j >= 1`: `dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])`.
6. Return `dp[m][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — fill an (m+1)×(n+1) table where m = s1.length, n = s2.length |
| Space | O(m·n) — the DP table |

---

## Solution 2: 1D DP (Space-Optimized) — O(m·n) time, O(n) space

**Idea:** Since `dp[i][j]` depends only on `dp[i-1][j]` and `dp[i][j-1]`, we can reduce to a single 1D array of size `n+1`, updated row by row.

**Algorithm:**
1. If lengths don't sum to `s3.length`, return `false`.
2. Initialize `dp[j]` using just `s2` vs `s3` prefix match.
3. For each row `i` (character of `s1`): update `dp[0]` from the column case, then for each `j >= 1` update `dp[j]` using the same transition.
4. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — same transitions, just space-compressed |
| Space | O(n) — single row array |
