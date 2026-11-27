# 1608. Special Array With X Elements Greater Than or Equal X — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

---

## Solution: Sort and Binary Search — O(n log n) time, O(1) space

**Idea:** After sorting, for each candidate `x` from 1 to n, use binary search to find how many elements are `>= x`. If that count equals `x`, return `x`.

**Algorithm:**
1. Sort `nums` in ascending order.
2. For each `x` in `[1, n]`:
   - Binary-search for the leftmost index where `nums[idx] >= x` (lower bound of `x`).
   - If `n - idx == x`, return `x`.
3. Return `-1` if no such `x` is found.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort plus n binary searches each O(log n) |
| Space | O(1) — in-place sort, no extra storage |
