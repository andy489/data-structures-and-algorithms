# 304. Range Sum Query 2D - Immutable — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-sum-query-2d-immutable/

---

## Solution: 2D Prefix Sum — O(m*n) build, O(1) query, O(m*n) space

**Idea:** Build a 2D prefix sum table where `prefix[i][j]` is the sum of all elements in the rectangle from `(0,0)` to `(i-1,j-1)`. Use inclusion-exclusion to answer any rectangle query in O(1).

**Algorithm:**
1. Build `prefix[m+1][n+1]` (1-indexed, padded with zeros).
2. `prefix[i][j] = matrix[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]`.
3. For `sumRegion(r1,c1,r2,c2)`: return `prefix[r2+1][c2+1] - prefix[r1][c2+1] - prefix[r2+1][c1] + prefix[r1][c1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) build, O(1) per query |
| Space | O(m*n) — prefix table |
