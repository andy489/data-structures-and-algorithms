# 849. Maximize Distance to Closest Person

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-distance-to-closest-person/

---

## Problem Statement

You are given an array representing a row of seats where `seats[i] = 1` represents a person sitting in the `i`th seat, and `seats[i] = 0` represents that the `i`th seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to the closest person.

---

## Examples

**Example 1:**
```
Input: seats = [1,0,0,0,1,0,1]
Output: 2
```

**Example 2:**
```
Input: seats = [1,0,0,0]
Output: 3
```

**Example 3:**
```
Input: seats = [0,1]
Output: 1
```

---

## Constraints

- `2 <= seats.length <= 2 * 10^4`
- `seats[i]` is `0` or `1`.
- At least one seat is empty.
- At least one seat is occupied.
