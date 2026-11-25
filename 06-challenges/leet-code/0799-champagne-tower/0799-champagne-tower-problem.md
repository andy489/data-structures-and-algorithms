# 799. Champagne Tower

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/champagne-tower/

---

## Problem Statement

We stack glasses in a pyramid, where the **first** row has `1` glass, the **second** row has `2` glasses, and so on until the 100th row. Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top. When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it. When those glasses become full, any excess that flows from the left and right glasses will fall equally to the left and right of those glasses, and so on. (A glass at the bottom row has its excess champagne fall on the floor.)

After pouring some non-negative integer cups of champagne, return how full the `j-th` glass in the `i-th` row is (both `i` and `j` are 0-indexed).

---

## Examples

**Example 1:**
```
Input:  poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
```

**Example 2:**
```
Input:  poured = 2, query_row = 1, query_glass = 1
Output: 0.50000
```

**Example 3:**
```
Input:  poured = 100000009, query_row = 33, query_glass = 17
Output: 1.00000
```

---

## Constraints

- `0 <= poured <= 10^9`
- `0 <= query_glass <= query_row < 100`
