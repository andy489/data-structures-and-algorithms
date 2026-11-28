# 3454. Separate Squares II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/separate-squares-ii/

---

## Solution: Binary Search + Coordinate Compression + Sweep Line — O(n^2 log n) time, O(n) space

**Idea:** Unlike version I, overlapping areas count only once. Binary search on y, and for each candidate line use coordinate compression and a sweep line to compute the actual union area above/below the line.

**Algorithm:**
1. Binary search on y between min and max y-coordinates.
2. For candidate line y = mid, compute area of union of rectangles below y = mid.
3. Use coordinate compression on x-coordinates and sweep line events to compute union area.
4. Total union area - area_below = area_above. Converge when they are equal.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 log n) |
| Space | O(n) |
