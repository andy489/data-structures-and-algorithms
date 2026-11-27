# 892. Surface Area of 3D Shapes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/surface-area-of-3d-shapes/

---

## Solution: Direct Calculation — O(n^2) time, O(1) space

**Idea:** Each tower of height h contributes 4*h (sides) + 2 (top+bottom if h>0) surfaces. Subtract 2*min(h1,h2) for each adjacent tower pair (shared faces).

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) |
