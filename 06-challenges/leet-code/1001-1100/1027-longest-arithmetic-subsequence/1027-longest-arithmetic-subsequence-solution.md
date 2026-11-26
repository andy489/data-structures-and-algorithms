# 1027. Longest Arithmetic Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-arithmetic-subsequence/

---

## Solution: DP with Hash Map — O(n²) time, O(n²) space

**Idea:** `dp[i]` is a map from difference to longest arithmetic subsequence ending at index i with that difference. For each pair (j, i), update dp[i][diff] = dp[j].get(diff, 1) + 1.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
