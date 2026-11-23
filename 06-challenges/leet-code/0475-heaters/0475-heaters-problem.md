# 475. Heaters

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/heaters/

---

## Problem Statement

Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.

Every house can be warmed, as long as the house is within the heater's warm radius range.

Given the positions of `houses` and `heaters` on a horizontal line, return *the minimum radius standard of heaters so that those heaters could cover all houses*.

**Notice** that all the `heaters` follow your radius standard, and the warm radius will the same.

---

## Examples

**Example 1:**
```
Input:  houses = [1,2,3], heaters = [2]
Output: 1
```

**Example 2:**
```
Input:  houses = [1,2,3,4], heaters = [1,4]
Output: 1
```

**Example 3:**
```
Input:  houses = [1,5], heaters = [2]
Output: 3
```

---

## Constraints

- `1 <= houses.length, heaters.length <= 3 * 10^4`
- `1 <= houses[i], heaters[j] <= 10^9`
