# 2249. Count Lattice Points Inside a Circle

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/count-lattice-points-inside-a-circle/

## Problem

Given a 2D integer array `circles` where `circles[i] = [xi, yi, ri]` represents the center `(xi, yi)` and radius `ri` of the `ith` circle drawn on a grid, return the number of **lattice points** that are present inside **at least one** circle.

**Note:**
- A lattice point is a point with integer coordinates.
- Points that lie on the circumference of a circle are also considered to be inside it.

## Examples

**Example 1:**

```
Input: circles = [[2,2,1]]
Output: 5
Explanation: The lattice points present inside the circle are (1,2), (2,1), (2,2), (2,3), and (3,2).
```

**Example 2:**

```
Input: circles = [[2,2,2],[3,4,1]]
Output: 16
Explanation: There are exactly 16 lattice points which are present inside at least one circle.
```

## Constraints

- `1 <= circles.length <= 200`
- `circles[i].length == 3`
- `1 <= xi, yi <= 100`
- `1 <= ri <= min(xi, yi)`
