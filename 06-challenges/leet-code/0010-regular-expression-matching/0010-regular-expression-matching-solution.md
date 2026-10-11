# 10. Regular Expression Matching — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/regular-expression-matching/

---

## Solution

### Dynamic Programming — O(m·n) time, O(m·n) space

**Define:** `dp[i][j]` = whether `s[0..i-1]` matches `p[0..j-1]`.

**Base cases:**
- `dp[0][0] = true` (empty string matches empty pattern).
- `dp[0][j]`: only patterns like `a*b*c*` can match an empty string — `dp[0][j] = dp[0][j-2]` when `p[j-1] == '*'`.

**Transitions:**

1. **Current pattern char is a letter or `'.'`:**
   ```
   dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1] || p[j-1] == '.')
   ```

2. **Current pattern char is `'*'`** (matches zero or more of `p[j-2]`):
   - **Zero occurrences:** `dp[i][j] |= dp[i][j-2]` (ignore the `x*` part entirely).
   - **One or more occurrences:** `dp[i][j] |= dp[i-1][j] && (s[i-1] == p[j-2] || p[j-2] == '.')`.

**Intuition for `'*'`:** Either we don't use the `x*` at all (consuming zero characters from `s`), or we match one more character and stay at the same pattern position (since `*` can match multiple times).

**Complexity:**

| | |
|---|---|
| Time | O(m · n) where m = len(s), n = len(p) |
| Space | O(m · n) for the DP table; reducible to O(n) with row rolling |
