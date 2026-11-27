# 1035. Uncrossed Lines — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/uncrossed-lines/

---

## Solution: LCS (Longest Common Subsequence) — O(m*n) time, O(m*n) space

**Idea:** This is exactly the LCS problem: a non-crossing matching between equal elements is an LCS.

**Algorithm:**
1. `dp[i][j]` = max connections using first i of nums1 and first j of nums2.
2. If `nums1[i-1] == nums2[j-1]`: `dp[i][j] = dp[i-1][j-1] + 1`.
3. Else: `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) |
