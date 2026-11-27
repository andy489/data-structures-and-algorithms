# 1637. Widest Vertical Area Between Two Points Containing No Points

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

---

## Problem Statement

Given `n` points on a 2D plane where `points[i] = [xi, yi]`, return the **widest vertical area** between two points such that no points are inside the area.

A vertical area is an area of fixed-width extending infinitely along the y-axis. The widest vertical area is the one with the maximum width, which is the maximum difference between adjacent x-coordinates after sorting.

---

## Examples

**Example 1:**
```
Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both empty vertical areas have width 1.
```

**Example 2:**
```
Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3
Explanation: The widest vertical area has width 3 (between x=5 and x=8).
```

---

## Constraints

- `n == points.length`
- `2 <= n <= 10^5`
- `points[i].length == 2`
- `0 <= xi, yi <= 10^9`
