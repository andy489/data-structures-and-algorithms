# 497. Random Point in Non-overlapping Rectangles — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

---

## Solution: Weighted Sampling with Prefix Sums — O(log n) per pick, O(n) space

**Idea:** Each rectangle has (xi-ai+1)*(yi-bi+1) integer points. Build a prefix sum of point counts. For pick(), randomly select a point index in [0, totalPoints), binary search for which rectangle it falls in, then uniformly pick coordinates within that rectangle.

**Algorithm:**
1. Precompute prefix[i] = cumulative count of integer points through rectangle i.
2. pick(): generate rand in [0, total). Binary search for rectangle. Compute local offset and convert to (x,y).

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(log n) per pick |
| Space | O(n) — prefix sum array |
