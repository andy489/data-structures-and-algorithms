# 1266. Minimum Time Visiting All Points

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-time-visiting-all-points/

---

## Problem Statement

On a 2D plane, there are `n` points with integer coordinates `points[i] = [xi, yi]`. Return the minimum time in seconds to visit all the points in the order given by `points`.

You can move according to these rules:
- In 1 second, you can either move vertically, horizontally, or diagonally by 1 unit.
- You have to visit the points in the same order as they appear in the array.
- You are allowed to pass through points that appear later in the order if such a move is needed.

---

## Examples

**Example 1:**
```
Input:  points = [[1,1],[3,4],[-1,0]]
Output: 7
```

---

## Constraints

- `points.length == n`
- `1 <= n <= 100`
- `points[i].length == 2`
- `-1000 <= points[i][0], points[i][1] <= 1000`
