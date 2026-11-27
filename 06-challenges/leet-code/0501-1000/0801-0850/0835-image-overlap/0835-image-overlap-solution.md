# 835. Image Overlap — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/image-overlap/

---

## Solution: Offset Counting — O(n⁴) time, O(n²) space

**Idea:** For each pair of 1-cells in img1 and img2, the offset (dr, dc) that aligns them is their coordinate difference. Count offset frequencies.

**Algorithm:**
1. Collect all 1-cell positions from each image.
2. For each pair (p1, p2) of 1-cells, compute offset = (p1.r - p2.r, p1.c - p2.c) and count it.
3. Return max count.

**Complexity:**

| | |
|---|---|
| Time | O(n⁴) — all pairs of cells; n ≤ 30 so max 810000 ops |
| Space | O(n²) — offset counter |
