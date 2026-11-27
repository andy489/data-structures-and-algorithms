# 1771. Maximize Palindrome Length From Subsequences — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/

---

## Solution: LPS DP on Concatenated String — O((n+m)^2) time, O((n+m)^2) space

**Idea:** Concatenate `s = word1 + word2`. Run the standard Longest Palindromic Subsequence DP on `s`. The answer requires at least one character from `word1` and one from `word2`, so we only count `dp[i][j]` values where `i` is in `word1` (index < n) and `j` is in `word2` (index >= n) and `s[i] == s[j]` — these `dp[i][j]` values capture a palindrome spanning both strings.

**Algorithm:**
1. Let `s = word1 + word2`, `n = len(word1)`, `len = len(s)`.
2. Run standard LPS DP: `dp[i][j]` = length of longest palindromic subsequence of `s[i..j]`.
3. For every pair `(i, j)` with `i < n <= j` and `s[i] == s[j]`, update `ans = max(ans, dp[i][j])`.
4. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O((n+m)^2) — DP table fill |
| Space | O((n+m)^2) — DP table |
