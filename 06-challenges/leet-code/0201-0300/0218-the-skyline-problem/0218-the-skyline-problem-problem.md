# 218. The Skyline Problem

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/the-skyline-problem/

---

## Problem Statement

A city's skyline is the outer contour of the silhouette formed by all the buildings as viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array `buildings` where `buildings[i] = [leftᵢ, rightᵢ, heightᵢ]`:

- `leftᵢ` is the x coordinate of the left edge of the `i`th building.
- `rightᵢ` is the x coordinate of the right edge of the `i`th building.
- `heightᵢ` is the height of the `i`th building.

You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height `0`.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form `[[x₁, y₁], [x₂, y₂], ...]`. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate `0` and is used to mark the skyline's termination where the rightmost building ends.

Any ground between the leftmost and rightmost buildings should be part of the skyline's contour. There must be no consecutive horizontal lines of equal height in the output skyline.

---

## Examples

**Example 1:**
```
Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
```

**Example 2:**
```
Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]
```

---

## Constraints

- `1 <= buildings.length <= 10^4`
- `0 <= leftᵢ < rightᵢ <= 2^31 - 1`
- `1 <= heightᵢ <= 2^31 - 1`
- `buildings` is sorted by `leftᵢ` in non-decreasing order.
