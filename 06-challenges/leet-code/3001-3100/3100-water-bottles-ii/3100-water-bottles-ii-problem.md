# 3100. Water Bottles Ii

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/water-bottles-ii/

---

## Problem Statement

You are given two integers `numBottles` and `numExchange`.

`numBottles` is the number of full water bottles and you start with `numExchange` as the number of empty bottles needed to exchange for a full one.

After each exchange, `numExchange` increases by 1.

Return the maximum number of water bottles you can drink.

---

## Examples

**Example 1:**
```
Input:  numBottles = 13, numExchange = 6
Output: 15
```
Explanation: Drink 13. Have 13 empty. Exchange 6→1 full (7 left). numExchange=7. Drink 1. Have 8 empty. Exchange 7→1 full (1 left). numExchange=8. Drink 1. Total=15. 2 empty < 8.

**Example 2:**
```
Input:  numBottles = 10, numExchange = 3
Output: 13
```
Explanation: Drink 10, exchange cycles give 3 more.

---

## Constraints

- `1 <= numBottles <= 100`
- `1 <= numExchange <= 100`
