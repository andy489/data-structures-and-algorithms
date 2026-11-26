# 1037. Valid Boomerang

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-boomerang/

---

## Problem Statement

Given an array `points` where `points[i] = [xi, yi]` represents a point on the **X-Y** plane, return `true` if these points are a **boomerang**.

A **boomerang** is a set of three points that are all distinct and not in a straight line.

---

## Examples

**Example 1:**
```
Input:  points = [[1,1],[2,3],[3,2]]
Output: true
```

**Example 2:**
```
Input:  points = [[1,1],[2,2],[3,3]]
Output: false
```

---

## Constraints

- `points.length == 3`
- `points[i].length == 2`
- `0 <= xi, yi <= 100`
