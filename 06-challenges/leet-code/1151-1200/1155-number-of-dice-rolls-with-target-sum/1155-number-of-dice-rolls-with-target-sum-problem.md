# 1155. Number of Dice Rolls With Target Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

---

## Problem Statement

You have `n` dice, and each die has `k` faces numbered from `1` to `k`.

Given three integers `n`, `k`, and `target`, return the number of possible ways to roll the dice so that the sum of the face-up numbers equals `target`. Since the answer may be too large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces. There is only one way to get a sum of 3.
```

**Example 2:**
```
Input:  n = 2, k = 6, target = 7
Output: 6
Explanation: (1,6), (2,5), (3,4), (4,3), (5,2), (6,1) — 6 ways.
```

**Example 3:**
```
Input:  n = 30, k = 30, target = 500
Output: 222616187
```

---

## Constraints

- `1 <= n, k <= 30`
- `1 <= target <= 1000`
