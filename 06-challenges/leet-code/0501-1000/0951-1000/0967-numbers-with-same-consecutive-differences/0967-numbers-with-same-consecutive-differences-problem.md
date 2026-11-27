# 967. Numbers With Same Consecutive Differences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/numbers-with-same-consecutive-differences/

---

## Problem Statement

Given two integers `n` and `k`, return an array of all the integers of length `n` such that the absolute difference between every two consecutive digits is `k`.

Note that every number in the answer must not have leading zeros. For example, `01` has one leading zero and is invalid.

You may return the answer in any order.

---

## Examples

**Example 1:**
```
Input:  n = 3, k = 7
Output: [181,292,707,818,929]
```

**Example 2:**
```
Input:  n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
```

---

## Constraints

- `2 <= n <= 9`
- `0 <= k <= 9`
