# 516. Longest Palindromic Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-palindromic-subsequence/

---

## Solution: DP — O(n²) time, O(n²) space

**Idea:** `dp[i][j]` = length of longest palindromic subsequence in `s[i..j]`. If `s[i] == s[j]`, extend inner palindrome; otherwise take max of skipping either end.

**Algorithm:**
1. `dp[i][i] = 1` for all i.
2. For length 2 to n: if `s[i] == s[j]`, `dp[i][j] = dp[i+1][j-1] + 2`; else `dp[i][j] = max(dp[i+1][j], dp[i][j-1])`.
3. Return `dp[0][n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) — DP table (reducible to O(n) with rolling array) |

---

## Solution 2: LCS of s and reverse(s) — O(n²) time, O(n²) space

**Idea:** The longest palindromic subsequence equals the LCS of `s` and `reverse(s)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
