# 427. Construct Quad Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-quad-tree/

---

## Solution: Recursive Divide and Conquer — O(n^2 log n) time, O(log n) space

**Idea:** Recursively check if a subgrid is uniform. If all cells share the same value, return a leaf node. Otherwise, split into four quadrants and recurse.

**Algorithm:**
1. For a given subgrid defined by `(row, col, size)`, check if all values are the same.
2. If uniform, return a leaf node with that value.
3. Otherwise, split size by 2 and recurse for each of the four quadrants (topLeft, topRight, bottomLeft, bottomRight).

**Complexity:**

| | |
|---|---|
| Time | O(n^2 log n) — each level checks O(n^2) cells across O(log n) recursion depths |
| Space | O(log n) — recursion depth |

---

## Solution 2: Prefix Sum Optimized — O(n^2) time, O(n^2) space

**Idea:** Precompute 2D prefix sums so any subgrid sum can be checked in O(1), making each node construction O(1).

**Algorithm:**
1. Build 2D prefix sum array.
2. Recursively build the tree; use prefix sum to check uniformity in O(1).

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — each cell processed once |
| Space | O(n^2) — prefix sum array |
