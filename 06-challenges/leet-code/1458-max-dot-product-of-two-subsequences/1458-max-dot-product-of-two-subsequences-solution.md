# 1458. Max Dot Product Of Two Subsequences — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-dot-product-of-two-subsequences/

---

## Solution: 2D DP — O(n*m) time, O(n*m) space

**Idea:** dp[i][j] = max dot product using subsequences of nums1[0..i] and nums2[0..j]. dp[i][j] = max(nums1[i]*nums2[j], dp[i-1][j-1]+nums1[i]*nums2[j], dp[i-1][j], dp[i][j-1]).

**Algorithm:**
1. Initialize dp with -inf.
2. dp[i][j] = max(nums1[i-1]*nums2[j-1] + max(0, dp[i-1][j-1]), dp[i-1][j], dp[i][j-1]).
3. Return dp[n][m].

**Complexity:**

| | |
|---|---|
| Time | O(n*m) |
| Space | O(n*m) |
