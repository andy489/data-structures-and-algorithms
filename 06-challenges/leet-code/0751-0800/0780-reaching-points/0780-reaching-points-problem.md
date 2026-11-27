# 780. Reaching Points

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reaching-points/

---

## Problem Statement

Given four integers `sx`, `sy`, `tx`, `ty`, return `true` if it is possible to convert the point `(sx, sy)` to the point `(tx, ty)` through some operations, otherwise return `false`.

The allowed operation is to convert `(x, y)` to either `(x + y, y)` or `(x, x + y)`.

---

## Examples

**Example 1:**
```
Input:  sx = 1, sy = 1, tx = 3, ty = 5
Output: true
Explanation: (1,1) → (1,2) → (3,2) → (3,5)
```

**Example 2:**
```
Input:  sx = 1, sy = 1, tx = 2, ty = 2
Output: false
```

**Example 3:**
```
Input:  sx = 1, sy = 1, tx = 1, ty = 1
Output: true
```

---

## Constraints

- `1 <= sx, sy, tx, ty <= 10^9`
