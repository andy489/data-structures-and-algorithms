# 307. Range Sum Query - Mutable — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-sum-query-mutable/

---

## Solution: Fenwick Tree (BIT) — O(log n) per operation time, O(n) space

**Idea:** Use a Binary Indexed Tree for O(log n) point updates and prefix sum queries.

**Algorithm:**
1. Build BIT from initial array in O(n log n).
2. `update(i, val)`: propagate delta through BIT.
3. `sumRange(l, r)`: return `prefix(r+1) - prefix(l)`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per operation |
| Space | O(n) |
