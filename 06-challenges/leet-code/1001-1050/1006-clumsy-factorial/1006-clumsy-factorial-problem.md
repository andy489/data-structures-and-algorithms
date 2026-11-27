# 1006. Clumsy Factorial

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/clumsy-factorial/

---

## Problem Statement

The factorial of a positive integer `n` is the product of all positive integers from `1` to `n`. However, we make it clumsy using a fixed rotation of operators in the form: `*, /, +, -`.

Given an integer `n`, return the clumsy factorial of `n`. Specifically, the clumsy factorial is using the integers in decreasing order, applying four operations `*, /, +, -` in cycles. The division is floor division.

---

## Examples

**Example 1:**
```
Input:  n = 4
Output: 7
Explanation: 4 * 3 / 2 + 1 = 7
```

**Example 2:**
```
Input:  n = 10
Output: 12
Explanation: 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1 = 12
```

---

## Constraints

- `1 <= n <= 10000`
