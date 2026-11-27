# 3394. Check if Grid Can Be Cut into Sections — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

---

## Solution: Interval Merge — O(n log n) time, O(n) space

**Idea:** Two horizontal cuts at y = a and y = b (a < b) are valid if rectangles can be grouped into three non-empty groups: those entirely below y = a, those entirely between a and b, and those entirely above y = b. This is equivalent to asking: when we project rectangles onto the y-axis as intervals `[starty, endy)`, can we find two "gaps" (points with no rectangle spanning across them) that split all intervals into three non-empty groups?

We check the same logic for vertical cuts (x-axis). The answer is true if either axis has at least 2 such gaps.

**Algorithm:**
1. Extract intervals `[starty, endy)` for all rectangles.
2. Sort by start point.
3. Merge overlapping intervals and count gaps (points where merged intervals end strictly before the next one begins).
4. If there are at least 2 gaps, return true.
5. Repeat for the x-axis with `[startx, endx)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sorting |
| Space | O(n) — for sorted interval list |
