# 1039. Minimum Score Triangulation of Polygon

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

---

## Problem Statement

You have a convex polygon with `n` vertices. The vertices are labelled from `0` to `n - 1` in a **clockwise** order and each vertex has an integer value given in the integer array `values`, where `values[i]` is the value of the `i`th vertex.

The **score** of a triangulation is the sum of the **products** of the values of the three vertices for each triangle in the triangulation. Return the minimum score of a triangulation of the polygon.

---

## Examples

**Example 1:**
```
Input:  values = [1,2,3]
Output: 6
```

**Example 2:**
```
Input:  values = [3,7,4,5]
Output: 144
```

---

## Constraints

- `n == values.length`
- `3 <= n <= 50`
- `1 <= values[i] <= 100`
