# 3454. Separate Squares II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/separate-squares-ii/

---

## Problem Statement

You are given a 2D integer array `squares`. Each `squares[i] = [xi, yi, li]` represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.

Find the **minimum** y-coordinate value of a horizontal line such that the total area covered by squares above the line *equals* the total area covered by squares below the line.

Answers within `10^-5` of the actual answer will be accepted.

**Note**: Squares **may** overlap. Overlapping areas should be counted **only once** in this version.

---

## Examples

**Example 1:**
```
Input: squares = [[0,0,1],[2,2,1]]
Output: 1.00000
```

**Example 2:**
```
Input: squares = [[0,0,2],[1,1,1]]
Output: 1.00000
```

---

## Constraints

- `1 <= squares.length <= 5 * 10^4`
- `squares[i] = [xi, yi, li]`
- `squares[i].length == 3`
- `0 <= xi, yi <= 10^9`
- `1 <= li <= 10^9`
- The total area of all the squares will not exceed `10^15`.
