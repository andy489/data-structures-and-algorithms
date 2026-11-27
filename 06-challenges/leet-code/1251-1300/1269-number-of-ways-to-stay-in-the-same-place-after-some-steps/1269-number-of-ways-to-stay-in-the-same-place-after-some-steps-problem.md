# 1269. Number of Ways to Stay in the Same Place After Some Steps

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

---

## Problem Statement

You have a pointer at index 0 in an array of size `arrLen`. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any point).

Given two integers `steps` and `arrLen`, return the number of ways such that your pointer is still at index 0 after exactly `steps` steps. Since the answer may be too large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  steps = 3, arrLen = 2
Output: 4
```

---

## Constraints

- `1 <= steps <= 500`
- `1 <= arrLen <= 10^6`
