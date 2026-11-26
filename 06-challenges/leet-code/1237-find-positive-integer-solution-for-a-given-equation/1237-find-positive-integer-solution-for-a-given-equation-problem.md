# 1237. Find Positive Integer Solution for a Given Equation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

---

## Problem Statement

Given a callable function `f(x, y)` with a hidden formula and a value `z`, return all positive integer pairs `x` and `y` where `f(x,y) == z`. You may return the answer in any order.

While the exact formula is hidden, the function is monotonically increasing, i.e.:
- `f(x, y) < f(x + 1, y)`
- `f(x, y) < f(x, y + 1)`

---

## Examples

**Example 1:**
```
Input:  customfunction's formula is x + y, z = 5
Output: [[1,4],[2,3],[3,2],[4,1]]
```

---

## Constraints

- `1 <= z <= 100`
