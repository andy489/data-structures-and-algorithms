# 1499. Max Value Of Equation

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-value-of-equation/

---

## Problem Statement

Return the maximum value of yi+yj+|xi-xj| where |xi-xj| <= k and i < j. Points are sorted by x.

---

## Examples

**Example 1:**
```
Input:  points=[[1,3],[2,0],[5,10],[6,-10]],k=1
Output: 4
```

**Example 2:**
```
Input:  points=[[0,0],[3,0],[9,2]],k=3
Output: 3
```

---

## Constraints

- `2 <= points.length <= 10^5`
- `-10^8 <= xi, yi <= 10^8`
- `xi strictly increasing`
- `0 <= k <= 2*10^8`
