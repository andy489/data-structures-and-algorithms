# 473. Matchsticks to Square

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/matchsticks-to-square/

---

## Problem Statement

You are given an integer array `matchsticks` where `matchsticks[i]` is the length of the `i`th matchstick. You want to use **all** the matchsticks to make one square. You **should not** break any stick, but you can link them up, and each matchstick must be used **exactly one time**.

Return `true` if you can make this square and `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  matchsticks = [1,1,2,2,2]
Output: true
```

**Example 2:**
```
Input:  matchsticks = [3,3,3,3,4]
Output: false
```

---

## Constraints

- `1 <= matchsticks.length <= 15`
- `1 <= matchsticks[i] <= 10^8`
