# 2110. Number of Smooth Descent Periods of a Stock

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/

---

## Problem Statement

You are given an integer array `prices` representing the daily price history of a stock, where `prices[i]` is the stock price on the ith day.

A **smooth descent period** of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.

Return the **number of smooth descent periods**.

---

## Examples

**Example 1:**
```
Input:  prices = [3,2,1,4]
Output: 7
Explanation: 7 smooth descent periods:
[3], [2], [1], [4], [3,2], [2,1], and [3,2,1].
```

**Example 2:**
```
Input:  prices = [8,6,7,7]
Output: 4
Explanation: 4 smooth descent periods: [8], [6], [7], and [7].
Note: [8,6] is not smooth because 8 - 6 ≠ 1.
```

**Example 3:**
```
Input:  prices = [1]
Output: 1
```

---

## Constraints

- `1 <= prices.length <= 10^5`
- `1 <= prices[i] <= 10^5`
