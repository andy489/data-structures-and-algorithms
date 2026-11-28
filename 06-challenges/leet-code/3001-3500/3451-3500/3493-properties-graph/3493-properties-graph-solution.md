# 3493. Properties Graph — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/properties-graph/

---

## Solution: Union-Find with Set Intersection — O(n^2 * m) time, O(n * m) space

**Idea:** Convert each `properties[i]` to a set for O(1) element lookup. For each pair of nodes `(i, j)`, count distinct common elements (intersection size). If intersection >= `k`, union them. Count the number of distinct components using Union-Find.

**Algorithm:**
1. Convert each row of `properties` to a `HashSet`.
2. Initialize Union-Find with `n` nodes.
3. For each pair `(i, j)` with `i < j`, compute set intersection size. If `>= k`, union `i` and `j`.
4. Count distinct roots — that is the number of connected components.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * m) |
| Space | O(n * m) |
