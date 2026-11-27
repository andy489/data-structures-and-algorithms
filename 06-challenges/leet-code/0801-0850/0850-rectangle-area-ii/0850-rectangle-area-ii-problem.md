# 850. Rectangle Area II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/rectangle-area-ii/

---

## Problem Statement

You are given a 2D array of axis-aligned rectangles `rectangles`. Each `rectangle[i] = [xi1, yi1, xi2, yi2]` denotes the `i`th rectangle where `(xi1, yi1)` are the coordinates of the bottom-left corner, and `(xi2, yi2)` are the coordinates of the top-right corner.

Calculate the **total area** covered by all `rectangles` in the plane. Any area covered by two or more rectangles should only be counted **once**.

Return the total area. Since the answer may be too large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
Output: 6
```

**Example 2:**
```
Input: rectangles = [[0,0,1000000000,1000000000]]
Output: 49
```

---

## Constraints

- `1 <= rectangles.length <= 200`
- `rectangles[i].length == 4`
- `0 <= xi1 < xi2 <= 10^9`
- `0 <= yi1 < yi2 <= 10^9`
- All the given rectangles do not overlap.
