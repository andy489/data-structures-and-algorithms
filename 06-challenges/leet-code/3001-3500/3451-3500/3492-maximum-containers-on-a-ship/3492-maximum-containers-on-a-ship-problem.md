# 3492. Maximum Containers on a Ship

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-containers-on-a-ship/

---

## Problem Statement

You are given a positive integer `n` representing an `n x n` cargo deck on a ship. Each cell on the deck can hold one container with a weight of **exactly** `w`.

However, the total weight of all containers, if loaded onto the deck, must not exceed the ship's maximum weight capacity, `maxWeight`.

Return the **maximum** number of containers that can be loaded onto the ship.

---

## Examples

**Example 1:**
```
Input: n = 2, w = 3, maxWeight = 15
Output: 4
```

**Example 2:**
```
Input: n = 3, w = 5, maxWeight = 20
Output: 4
```

---

## Constraints

- `1 <= n <= 1000`
- `1 <= w <= 1000`
- `1 <= maxWeight <= 10^9`
