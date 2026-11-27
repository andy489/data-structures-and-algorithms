# 1691. Maximum Height by Stacking Cuboids — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-height-by-stacking-cuboids/

---

## Solution: Sort + LIS-style DP — O(n^2) time, O(n) space

**Idea:** Key insight: in the optimal solution, we can always sort each cuboid's dimensions so `w <= l <= h`, and then sort all cuboids. A cuboid `i` can be placed on `j` iff all three dimensions of `i` are <= corresponding dimensions of `j` (after sorting each cuboid).

**Algorithm:**
1. Sort each cuboid's dimensions.
2. Sort all cuboids lexicographically.
3. `dp[i]` = max height of stack with cuboid `i` on top.
4. For each `i`, try all `j < i`: if `j` can support `i`, `dp[i] = max(dp[i], dp[j] + height[i])`.
5. Return `max(dp)`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
