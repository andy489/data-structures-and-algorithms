# 3000. Maximum Area Of Longest Diagonal Rectangle

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

---

## Problem Statement

Given a 2D 0-indexed integer array `dimensions` where `dimensions[i] = [length_i, width_i]` represents the dimensions of the ith rectangle.

Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle with the maximum area.

---

## Examples

**Example 1:**
```
Input:  dimensions = [[9,3],[8,6]]
Output: 48
```
Explanation: For index 0, length = 9, width = 3. Diagonal = sqrt(81+9) = sqrt(90).
For index 1, length = 8, width = 6. Diagonal = sqrt(64+36) = sqrt(100).
So index 1 has the longest diagonal and its area is 8*6 = 48.

**Example 2:**
```
Input:  dimensions = [[3,4],[4,3]]
Output: 12
```
Explanation: Length of diagonal is the same for both. Max area = 12.

---

## Constraints

- `1 <= dimensions.length <= 100`
- `dimensions[i].length == 2`
- `1 <= dimensions[i][0], dimensions[i][1] <= 100`
