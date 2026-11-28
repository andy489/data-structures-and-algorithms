# 3488. Closest Equal Element Queries — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/closest-equal-element-queries/

---

## Solution: HashMap + Sorted List Binary Search — O((n + q) log n) time, O(n) space

**Idea:** Precompute for each value all indices where it appears (sorted). For each query, binary search among the positions of the same value to find the nearest one in circular distance.

**Algorithm:**
1. Build `positions` map: value -> sorted list of indices.
2. For each query index `qi` with value `v`:
   - If `positions[v]` has only 1 element, answer is -1.
   - Otherwise, binary search for `qi` in `positions[v]`, check predecessor and successor (wrap around for circular).
3. Circular distance between indices `a` and `b` in array of length `n`: `min(|a-b|, n - |a-b|)`.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log n) |
| Space | O(n) |
