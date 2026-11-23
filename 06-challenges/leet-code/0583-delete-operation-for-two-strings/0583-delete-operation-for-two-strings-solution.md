# 583. Delete Operation for Two Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-operation-for-two-strings/

---

## Solution: LCS-based DP — O(m·n) time, O(m·n) space

**Idea:** The minimum deletions = `m + n - 2 * LCS(word1, word2)`. Find the Longest Common Subsequence (LCS) with standard DP.

**Algorithm:**
1. Build `dp[i][j]` = LCS length of `word1[0..i-1]` and `word2[0..j-1]`.
2. If `word1[i-1] == word2[j-1]`: `dp[i][j] = dp[i-1][j-1] + 1`.
3. Else: `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.
4. Answer = `m + n - 2 * dp[m][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) — reducible to O(min(m,n)) with rolling array |
