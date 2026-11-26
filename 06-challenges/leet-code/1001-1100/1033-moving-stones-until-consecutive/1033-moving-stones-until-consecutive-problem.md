# 1033. Moving Stones Until Consecutive

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/moving-stones-until-consecutive/

---

## Problem Statement

There are three stones at positions `a`, `b`, and `c` on a number line. In each turn, you pick up a stone at an endpoint (i.e. either the lowest or highest position stone), and move it to an unoccupied position between the two other stones.

Return an array of two integers: the minimum and maximum number of moves to make the stones in three consecutive positions.

---

## Examples

**Example 1:**
```
Input:  a = 1, b = 2, c = 5
Output: [1, 2]
```

**Example 2:**
```
Input:  a = 4, b = 3, c = 2
Output: [0, 0]
```

---

## Constraints

- `1 <= a, b, c <= 100`
- `a`, `b`, `c` have distinct values.
