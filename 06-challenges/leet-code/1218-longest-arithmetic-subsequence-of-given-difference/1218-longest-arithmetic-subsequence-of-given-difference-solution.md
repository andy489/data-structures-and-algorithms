# 1218. Longest Arithmetic Subsequence of Given Difference — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

---

## Solution: Dynamic Programming with HashMap — O(n) time, O(n) space

**Idea:** dp[x] = length of longest valid subsequence ending at value x. For each element x, dp[x] = dp[x - difference] + 1.

**Algorithm:**
1. Iterate through arr.
2. For each x: dp[x] = dp.getOrDefault(x - difference, 0) + 1.
3. Track maximum dp value.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
