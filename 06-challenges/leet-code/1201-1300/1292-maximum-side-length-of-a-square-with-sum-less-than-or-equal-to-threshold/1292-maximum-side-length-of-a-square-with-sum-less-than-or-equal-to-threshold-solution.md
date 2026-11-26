# 1292. Maximum Side Length of a Square with Sum Less Than or Equal to Threshold — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

---

## Solution: 2D Prefix Sums — O(m*n*min(m,n)) time, O(m*n) space

**Idea:** Build a 2D prefix sum array. Then for each possible square size, check all positions.

**Algorithm:**
1. Build prefix sum array.
2. Binary search or linear scan on side length.
3. For each (i,j) and side k: sum = prefix[i][j] - prefix[i-k][j] - prefix[i][j-k] + prefix[i-k][j-k].

**Complexity:**

| | |
|---|---|
| Time | O(m*n*min(m,n)) |
| Space | O(m*n) |
