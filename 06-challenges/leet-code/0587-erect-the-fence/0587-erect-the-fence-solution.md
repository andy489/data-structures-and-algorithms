# 587. Erect the Fence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/erect-the-fence/

---

## Solution: Monotone Chain (Andrew's Algorithm) — O(n log n) time, O(n) space

**Idea:** Build the convex hull using the monotone chain algorithm. Sort points by x (then y). Build lower and upper hulls. Use cross product to determine turns; keep collinear points on edges (use `cross <= 0` check).

**Algorithm:**
1. Sort all points by x-coordinate, breaking ties by y.
2. Build lower hull left-to-right; pop points that make a right turn (cross product < 0).
3. Build upper hull right-to-left similarly.
4. Combine (dedup start/end) and return unique points using a HashSet.

**Cross product** of vectors OA and OB: `(A.x-O.x)*(B.y-O.y) - (A.y-O.y)*(B.x-O.x)`. Negative = right turn (clockwise), remove.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) for sorting |
| Space | O(n) |
