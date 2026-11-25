# 1039. Minimum Score Triangulation of Polygon — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

---

## Solution: Interval DP — O(n³) time, O(n²) space

**Idea:** `dp[i][j]` = min score to triangulate the sub-polygon from vertex i to vertex j (along the boundary). For the base triangle, pick a middle vertex k.

**Algorithm:**
1. `dp[i][j] = min over k in (i+1..j-1) of dp[i][k] + values[i]*values[k]*values[j] + dp[k][j]`.
2. Length 2 intervals (single edge) have score 0.
3. Build up for increasing interval lengths.

**Complexity:**

| | |
|---|---|
| Time | O(n³) |
| Space | O(n²) |
