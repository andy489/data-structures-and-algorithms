# 3380. Maximum Area Rectangle With Point Constraints I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/

---

## Problem Statement

You are given an array `points` where `points[i] = [xi, yi]` represents the coordinates of a point on an infinite plane.

Your task is to find the **maximum** area of a rectangle that:

- Can be formed using **four** of these points as its corners.
- Does **not** contain any other point inside or on its border.
- Has its edges **parallel** to the axes.

Return the **maximum area** that you can obtain or -1 if no such rectangle is possible.

---

## Examples

**Example 1:**
```
Input:  points = [[1,1],[1,3],[3,1],[3,3]]
Output: 4
```
Explanation: These 4 points form a rectangle with no interior points, so area = 4.

**Example 2:**
```
Input:  points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: -1
```
Explanation: The only rectangle candidate contains [2,2] inside, so -1.

**Example 3:**
```
Input:  points = [[1,1],[1,3],[3,1],[3,3],[1,2],[3,2]]
Output: 2
```
Explanation: The rectangle [1,2],[1,3],[3,2],[3,3] has area 2 with no interior or border points.

---

## Constraints

- `1 <= points.length <= 10`
- `points[i].length == 2`
- `0 <= xi, yi <= 100`
- All the given points are **unique**.
