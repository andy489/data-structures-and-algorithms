# 973. K Closest Points to Origin

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-closest-points-to-origin/

---

## Problem Statement

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

The distance between two points on the X-Y plane is the Euclidean distance (i.e., `√(x² + y²)`).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

---

## Examples

**Example 1:**
```
Input:  points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
```

**Example 2:**
```
Input:  points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
```

---

## Constraints

- `1 <= k <= points.length <= 10^4`
- `-10^4 <= xi, yi <= 10^4`
