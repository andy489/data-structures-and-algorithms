# 718. Maximum Length of Repeated Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-length-of-repeated-subarray/

---

## Solution: 2D DP — O(mn) time, O(mn) space

**Idea:** `dp[i][j]` = length of the longest common subarray ending at `nums1[i-1]` and `nums2[j-1]`. If elements match, extend the previous diagonal; otherwise 0.

**Algorithm:**
1. Init `dp[m+1][n+1]` all zeros, `ans = 0`.
2. For i,j from 1..m and 1..n: if `nums1[i-1] == nums2[j-1]`, `dp[i][j] = dp[i-1][j-1] + 1`, update `ans`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(mn) |
| Space | O(mn) — reducible to O(min(m,n)) with rolling array |
