# 1659. Maximize Grid Happiness

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-grid-happiness/

---

## Problem Statement

You are given four integers, `m`, `n`, `introvertsCount`, and `extrovertsCount`. You have an `m x n` grid, and there are two types of people: introverts and extroverts. There are `introvertsCount` introverts and `extrovertsCount` extroverts.

You should decide how many people and of which type to place in each cell. Note that you do not have to place everyone.

The happiness of each person is calculated as follows:

- Introverts **start** with 120 happiness and **lose** 30 happiness for each neighbor (adjacent person).
- Extroverts **start** with 40 happiness and **gain** 20 happiness for each neighbor.

Neighbors live in the directly adjacent cells (up, down, left, right).

Return the **maximum sum of the happiness** of all the people.

---

## Examples

**Example 1:**
```
Input: m = 2, n = 3, introvertsCount = 1, extrovertsCount = 2
Output: 240
Explanation: Place introverts in (0,0) and extroverts in (1,0) and (0,1).
- (0,0) introvert with 1 neighbor: 120 - 30 = 90 happiness
- (0,1) extrovert with 1 neighbor: 40 + 20 = 60 happiness  
- (1,0) extrovert with 1 neighbor: 40 + 20 = 60 happiness
Total = 240.
```

**Example 2:**
```
Input: m = 3, n = 1, introvertsCount = 2, extrovertsCount = 1
Output: 260
```

**Example 3:**
```
Input: m = 2, n = 2, introvertsCount = 4, extrovertsCount = 0
Output: 240
```

---

## Constraints

- `1 <= m, n <= 5`
- `0 <= introvertsCount, extrovertsCount <= min(m * n, 6)`
