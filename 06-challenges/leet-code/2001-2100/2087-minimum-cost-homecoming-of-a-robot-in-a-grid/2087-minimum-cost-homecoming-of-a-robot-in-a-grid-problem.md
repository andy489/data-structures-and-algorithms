# 2087. Minimum Cost Homecoming of a Robot in a Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

---

## Problem Statement

A robot starts at `startPos` on a grid and needs to go to `homePos`. Moving to row `r` costs `rowCosts[r]`, moving to column `c` costs `colCosts[c]`. Return minimum cost.

---

## Examples

**Example 1:**
```
Input:  startPos = [1,0], homePos = [2,3], rowCosts = [5,4,3], colCosts = [8,2,6,7]
Output: 18
```
Explanation: Move down (cost 3) + right×3 (2+6+7=15). Total 18.

**Example 2:**
```
Input:  startPos = [0,0], homePos = [0,0], rowCosts = [5], colCosts = [26]
Output: 0
```
Explanation: Already home.

---

## Constraints

- `m == rowCosts.length`
- `n == colCosts.length`
- `1 <= m, n <= 10^5`
- `0 <= rowCosts[i], colCosts[j] <= 10^4`
- `startPos.length == homePos.length == 2`
