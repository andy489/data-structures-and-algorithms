# 850. Rectangle Area II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/rectangle-area-ii/

---

## Solution: Coordinate Compression + Sweep Line — O(n² log n) time, O(n²) space

**Idea:** Compress x-coordinates. Sweep a vertical line, tracking which y-intervals are covered using events. For each x-slab, compute covered y-length and multiply by slab width.

**Algorithm:**
1. Collect all unique x-coordinates, sort and deduplicate.
2. For each consecutive pair `(x1, x2)`, find all rectangles that span this x-slab.
3. Collect their y-intervals and compute total covered y-length (merge intervals).
4. Add `(x2 - x1) * coveredY` to the answer, modulo 10^9 + 7.

**Complexity:**

| | |
|---|---|
| Time | O(n² log n) — n x-slabs × n intervals + sorting |
| Space | O(n²) — coordinate lists |
