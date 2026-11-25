# 883. Projection Area of 3D Shapes — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/projection-area-of-3d-shapes/

---

## Solution: Direct Calculation — O(n^2) time, O(1) space

**Idea:** XY projection: count non-zero cells. YZ projection: sum of max in each row. ZX projection: sum of max in each column.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) |
