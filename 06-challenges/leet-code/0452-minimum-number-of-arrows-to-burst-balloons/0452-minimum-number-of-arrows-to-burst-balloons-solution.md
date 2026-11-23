# 452. Minimum Number of Arrows to Burst Balloons — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

---

## Solution: Greedy (Sort by End) — O(n log n) time, O(1) space

**Idea:** Sort balloons by their right endpoint. Shoot an arrow at the first balloon's right end — this bursts all overlapping balloons. Move to the first unbursted balloon and repeat.

**Algorithm:**
1. Sort `points` by `xend` (right endpoint).
2. Set `arrowPos` to the right end of the first balloon. Count = 1.
3. For each subsequent balloon, if `xstart > arrowPos`, shoot a new arrow at `xend`, update `arrowPos`, increment count.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(1) — in-place sort (or O(log n) for sort stack) |
