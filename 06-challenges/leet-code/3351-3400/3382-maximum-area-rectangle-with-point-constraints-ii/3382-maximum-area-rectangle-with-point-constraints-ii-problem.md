# 3382. Maximum Area Rectangle With Point Constraints II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/

---

## Problem Statement

There are n points on an infinite plane. You are given two integer arrays `xCoord` and `yCoord` where `(xCoord[i], yCoord[i])` represents the coordinates of the `i`-th point.

Your task is to find the **maximum** area of a rectangle that:

- Can be formed using **four** of these points as its corners.
- Does **not** contain any other point inside or on its border.
- Has its edges **parallel** to the axes.

Return the **maximum area** that you can obtain or -1 if no such rectangle is possible.

---

## Examples

**Example 1:**
```
Input:  xCoord = [1,1,3,3], yCoord = [1,3,1,3]
Output: 4
```
Explanation: These 4 points form a 2×2 rectangle with no interior points.

**Example 2:**
```
Input:  xCoord = [1,1,3,3,2], yCoord = [1,3,1,3,2]
Output: -1
```
Explanation: The only rectangle candidate contains point (2,2) inside.

**Example 3:**
```
Input:  xCoord = [1,1,3,3,1,3], yCoord = [1,3,1,3,2,2]
Output: 2
```
Explanation: Rectangles [1,2],[1,3],[3,2],[3,3] and [1,1],[1,2],[3,1],[3,2] both have area 2.

---

## Constraints

- `1 <= xCoord.length == yCoord.length <= 2 * 10^5`
- `0 <= xCoord[i], yCoord[i] <= 8 * 10^7`
- All the given points are **unique**.
