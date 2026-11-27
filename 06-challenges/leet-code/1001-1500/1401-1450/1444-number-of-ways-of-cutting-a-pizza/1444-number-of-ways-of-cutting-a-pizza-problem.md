# 1444. Number Of Ways Of Cutting A Pizza

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

---

## Problem Statement

Given a rectangular pizza with apples and an integer `k`, cut the pizza into `k` pieces such that each piece has at least one apple. Return number of ways mod 10^9+7.

---

## Examples

**Example 1:**
```
Input:  pizza=["A..","AAA","..."],k=3
Output: 3
```

**Example 2:**
```
Input:  pizza=["A..","AA.","..."],k=3
Output: 1
```

---

## Constraints

- `1 <= rows, cols <= 50`
- `1 <= k <= 10`
- `pizza[i][j] is 'A' or '.'`
