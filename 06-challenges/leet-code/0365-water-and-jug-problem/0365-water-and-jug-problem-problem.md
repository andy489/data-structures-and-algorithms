# 365. Water and Jug Problem

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/water-and-jug-problem/

---

## Problem Statement

You are given two jugs with capacities `x` liters and `y` liters. You have an infinite water supply. Return whether the total amount of water in both jugs may reach `target` liters.

The two jugs initially have no water. The following operations are allowed:
- Fill either jug completely with water.
- Completely empty either jug.
- Pour water from one jug into another until the receiving jug is full, or the transferring jug is empty.

---

## Examples

**Example 1:**
```
Input:  x = 3, y = 5, target = 4
Output: true
```

**Example 2:**
```
Input:  x = 2, y = 6, target = 5
Output: false
```

**Example 3:**
```
Input:  x = 1, y = 2, target = 3
Output: true
```

---

## Constraints

- `1 <= x, y, target <= 1000`
