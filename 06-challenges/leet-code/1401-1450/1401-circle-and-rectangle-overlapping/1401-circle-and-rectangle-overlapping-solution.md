# 1401. Circle And Rectangle Overlapping — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circle-and-rectangle-overlapping/

---

## Solution: Closest Point Clamp — O(1) time, O(1) space

**Idea:** Clamp the circle center to the nearest point on the rectangle; check if that distance is ≤ radius.

**Algorithm:**
1. Clamp: `cx = clamp(xCenter, x1, x2)`, `cy = clamp(yCenter, y1, y2)`.
2. Return `(xCenter-cx)^2 + (yCenter-cy)^2 <= radius^2`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
