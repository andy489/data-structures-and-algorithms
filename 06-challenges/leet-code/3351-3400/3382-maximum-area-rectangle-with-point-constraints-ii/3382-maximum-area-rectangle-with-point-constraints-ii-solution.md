# 3382. Maximum Area Rectangle With Point Constraints II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/

---

## Solution: Sweep Line + BIT (Coordinate Compression) — O(n^2 log n) time, O(n) space

**Idea:** Group points by x-coordinate. Sort x-columns right to left. For each pair of y-values `(yLo, yHi)` appearing in the same column, check if a **previous** (right) column also has both those y-values. If so, we have a rectangle candidate. The key constraint is "no other point on the border or inside": for a rectangle with columns `x1 < x2` and rows `y1 < y2`, there must be **no** point with `x1 < x <= x2` and `y1 <= y <= y2` other than the four corners. We enforce this using a Fenwick (BIT) tree on compressed y-values.

**Algorithm:**
1. Coordinate-compress all y-values.
2. Group points by x-coordinate; sort x-columns in decreasing order.
3. Maintain a BIT counting points by y. As we sweep right to left, for each column `x`:
   a. For every pair `(yLo, yHi)` in this column, query the BIT for the count of points in `[yLo, yHi]`. If the count equals 2 (only the two edge points were added from the previous column step), the rectangle is valid. Record area `(x2 - x) * (yHi - yLo)`.
   b. Store the last-seen x for each pair `(yLo, yHi)` in a hash map.
   c. Add all points of this column to the BIT.
4. Return the maximum valid area, or -1.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 log n) — worst case O(n) pairs per column, O(n) columns, O(log n) BIT ops |
| Space | O(n) — BIT and pair map |
