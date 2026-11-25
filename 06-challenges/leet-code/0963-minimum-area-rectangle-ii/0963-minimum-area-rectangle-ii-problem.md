# 963. Minimum Area Rectangle II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-area-rectangle-ii/

---

## Problem Statement

You are given an array of points in the X-Y plane `points` where `points[i] = [xi, yi]`.

Return the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the X and Y axes. If there is no such rectangle, return `0`.

Answers within `10^-5` of the actual answer will be accepted.

---

## Examples

**Example 1:**
```
Input:  points = [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
```

**Example 2:**
```
Input:  points = [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
```

---

## Constraints

- `1 <= points.length <= 50`
- `points[i].length == 2`
- `0 <= xi, yi <= 4 * 10^4`
- All the given points are unique.
