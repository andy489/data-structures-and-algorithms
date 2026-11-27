# 1798. Maximum Number of Consecutive Values You Can Make

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

---

## Problem Statement

You are given an integer array `coins` of length `n` which represents the `n` coins that you own. The value of the `i`th coin is `coins[i]`. You can **make** some value `x` if the sum of a subset of your coins equals `x`.

Return the **maximum** number of consecutive integer values that you can make with your coins starting from and **including** `0`.

Note that you may use each coin at most once.

---

## Examples

**Example 1:**
```
Input: coins = [1,3]
Output: 2
Explanation: You can make the following values:
- 0: take []
- 1: take [1]
You can't make 2, so the answer is 2.
```

**Example 2:**
```
Input: coins = [1,1,1,4]
Output: 8
Explanation: You can make the following values:
- 0,1,2,3,4,5,6,7
You can't make 8, so the answer is 8.
```

**Example 3:**
```
Input: coins = [1,4,10,3,1]
Output: 20
```

---

## Constraints

- `coins.length == n`
- `1 <= n <= 4 * 10^4`
- `1 <= coins[i] <= 4 * 10^4`
