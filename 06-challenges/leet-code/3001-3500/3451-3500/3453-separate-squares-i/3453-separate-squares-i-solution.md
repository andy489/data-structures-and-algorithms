# 3453. Separate Squares I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/separate-squares-i/

---

## Solution: Binary Search on Answer — O(n log n) time, O(n) space

**Idea:** Binary search on the y-coordinate of the horizontal line. For a given y, compute the total area above and below by integrating each square's contribution. Since overlapping areas are counted multiple times, each square contributes independently.

**Algorithm:**
1. Collect all critical y-values (bottom and top of each square).
2. Binary search between the minimum and maximum y across all squares.
3. For a candidate line y = mid, compute area above and below using each square's contribution: area of square below line = width * min(top, mid) - bottom (clamped to 0), area above = total_square_area - area_below.
4. Converge when |area_above - area_below| < eps.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max_y / eps)) |
| Space | O(1) |
