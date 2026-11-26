# 712. Minimum ASCII Delete Sum for Two Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

---

## Solution: DP (LCS variant) — O(mn) time, O(mn) space

**Idea:** `dp[i][j]` = minimum ASCII delete sum to make `s1[0..i-1]` and `s2[0..j-1]` equal.

**Algorithm:**
1. Base cases: `dp[i][0]` = sum of ASCII of `s1[0..i-1]`; `dp[0][j]` = sum of ASCII of `s2[0..j-1]`.
2. If `s1[i-1] == s2[j-1]`: `dp[i][j] = dp[i-1][j-1]` (no deletion needed for these chars).
3. Else: `dp[i][j] = min(dp[i-1][j] + s1[i-1], dp[i][j-1] + s2[j-1])`.

**Complexity:**

| | |
|---|---|
| Time | O(mn) |
| Space | O(mn) — can be reduced to O(min(m,n)) with rolling array |
