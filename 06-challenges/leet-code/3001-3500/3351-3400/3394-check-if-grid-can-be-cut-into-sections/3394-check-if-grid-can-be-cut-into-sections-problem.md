# 3394. Check if Grid Can Be Cut into Sections

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

---

## Problem Statement

You are given an integer `n` representing the dimensions of an `n x n` grid. You are also given a 2D array `rectangles`, where `rectangles[i] = [startx, starty, endx, endy]` represents a rectangle that occupies the area from `(startx, starty)` to `(endx, endy)` in the grid. All rectangles are non-overlapping.

Determine if it is possible to make **exactly two** horizontal or **exactly two** vertical cuts on the grid such that:

- Each of the three resulting sections contains **at least one** rectangle.
- Every rectangle belongs to **exactly one** section.

Return `true` if such cuts exist, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input:  n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
Output: true
```
Explanation: Horizontal cuts at y = 2 and y = 4 work.

**Example 2:**
```
Input:  n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
Output: true
```
Explanation: Vertical cuts at x = 2 and x = 3 work.

**Example 3:**
```
Input:  n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
Output: false
```
Explanation: No valid pair of cuts exists.

---

## Constraints

- `3 <= n <= 10^9`
- `3 <= rectangles.length <= 10^5`
- `0 <= rectangles[i][0] < rectangles[i][2] <= n`
- `0 <= rectangles[i][1] < rectangles[i][3] <= n`
- No two rectangles overlap.
