# 1473. Paint House Iii — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/paint-house-iii/

---

## Solution: 3D DP — O(m*n*target*n) time, O(m*n*target) space

**Idea:** dp[i][j][k] = min cost for houses 0..i, house i has color j, with k neighborhoods.

**Algorithm:**
1. Initialize dp with infinity. dp[-1][0][0] = 0 (before first house).
2. For each house i: for each color c: for each neighborhood count k: transition from all previous colors.
3. Return min over j of dp[m-1][j][target].

**Complexity:**

| | |
|---|---|
| Time | O(m*n*target*n) |
| Space | O(m*n*target) |
