# 1610. Maximum Number of Visible Points

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-visible-points/

---

## Problem Statement

You are given an array `points`, an integer `angle`, and your `location`, where `location = [posx, posy]` and `points[i] = [xi, yi]` both denote **integral coordinates** on the X-Y plane.

Initially, you are facing directly east from your position. You cannot move from your position, but you can **rotate**. For every rotation of `angle` degrees, you can see all the points that lie in that half-open interval `[direction, direction + angle]` (measured counter-clockwise).

A point can be seen if it lies **strictly within** the visible region **or** if the observer's location equals the point.

Return the maximum number of points you can see.

---

## Examples

**Example 1:**
```
Input: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
Output: 3
```

**Example 2:**
```
Input: points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
Output: 4
```

**Example 3:**
```
Input: points = [[1,0],[2,1]], angle = 13, location = [1,1]
Output: 1
```

---

## Constraints

- `1 <= points.length <= 10^5`
- `points[i].length == 2`
- `location.length == 2`
- `0 <= angle < 360`
- `0 <= posx, posy, xi, yi <= 100`
