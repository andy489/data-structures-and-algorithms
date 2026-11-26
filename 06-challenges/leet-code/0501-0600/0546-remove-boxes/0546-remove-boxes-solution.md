# 546. Remove Boxes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/remove-boxes/

---

## Solution: 3D Interval DP — O(n^4) time, O(n^3) space

**Idea:** `dp[l][r][k]` = max points from boxes[l..r] when k extra boxes identical to boxes[l] are attached to the left. At each state, either remove boxes[l] together with the k attached boxes, or find a matching element in [l+1..r] to defer removal.

**Algorithm:**
1. Base: `dp[i][i][k] = (k+1)^2`.
2. Recurse: `dp[l][r][k] = dp[l+1][r][0] + (k+1)^2` (remove boxes[l]+k immediately).
3. For each `m` in [l+1..r] where `boxes[m] == boxes[l]`: try `dp[l+1][m-1][0] + dp[m][r][k+1]`.
4. Memoize with 3D array.

**Complexity:**

| | |
|---|---|
| Time | O(n^4) — states O(n^3), transition O(n) |
| Space | O(n^3) — memo table |
