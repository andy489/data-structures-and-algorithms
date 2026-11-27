# 732. My Calendar III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/my-calendar-iii/

---

## Solution: Difference Array (TreeMap) — O(n log n) time, O(n) space

**Idea:** Use a sorted map as a difference array. For event `[start, end)`, increment `diff[start]` and decrement `diff[end]`. Scan the difference array prefix sums to find the maximum concurrent booking count.

**Algorithm:**
1. For `book(start, end)`: `diff[start]++`, `diff[end]--`.
2. Scan all entries in sorted order, computing running sum. Track maximum.
3. Return maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — TreeMap operations + scan |
| Space | O(n) — difference array entries |
