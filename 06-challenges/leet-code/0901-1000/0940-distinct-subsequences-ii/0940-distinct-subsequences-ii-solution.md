# 940. Distinct Subsequences II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/distinct-subsequences-ii/

---

## Solution: DP with Last Char Tracking — O(n) time, O(26) space

**Idea:** `dp[c]` = number of distinct subsequences ending with character c. When we add character s[i], new subsequences = sum of all dp[c] + 1 (the single-char subsequence). This is `dp[s[i]] = total + 1`. Total = sum(dp[c]).

**Algorithm:**
1. For each char c: dp[c] = current_total + 1; total = sum(dp).
2. Answer = total.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(26) = O(1) |
