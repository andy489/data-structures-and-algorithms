# 3472. Longest Palindromic Subsequence After at Most K Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/

---

## Solution: 2D DP with Budget — O(n^2 * k) time, O(n^2 * k) space

**Idea:** Extend the classic LPS DP to also track remaining operations. The cost to make characters s[i] and s[j] equal (for a palindrome pair) is min(|s[i]-s[j]|, 26-|s[i]-s[j]|). Use DP where dp[i][j][ops] = longest palindromic subsequence of s[i..j] using at most ops operations.

**Algorithm:**
1. Let n = s.length. Define dp[i][j][b] = LPS length for s[i..j] with at most b operations budget.
2. Base: dp[i][i][b] = 1 for all b >= 0.
3. Transition: if s[i] == s[j], dp[i][j][b] = dp[i+1][j-1][b] + 2. Otherwise compute cost c = min(|s[i]-s[j]|, 26-|s[i]-s[j]|). If b >= c, dp[i][j][b] = max(dp[i+1][j-1][b-c] + 2, dp[i+1][j][b], dp[i][j-1][b]). Else dp[i][j][b] = max(dp[i+1][j][b], dp[i][j-1][b]).
4. Return dp[0][n-1][k].

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * k) |
| Space | O(n^2 * k) |
