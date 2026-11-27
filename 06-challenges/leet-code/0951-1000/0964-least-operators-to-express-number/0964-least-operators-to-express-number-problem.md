# 964. Least Operators to Express Number

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/least-operators-to-express-number/

---

## Problem Statement

Given a single positive integer `x`, we will write an expression of the form `x (op1) x (op2) x (op3) x ...` where each operator `op1`, `op2`, ... is either addition, subtraction, multiplication, or division (`+`, `-`, `*`, or `/`).

For example, with `x = 3`, we might write `3 * 3 / 3 + 3 - 3` which is a value of `3`.

Return the least number of operators used.

---

## Examples

**Example 1:**
```
Input:  x = 3, target = 19
Output: 5
```

**Example 2:**
```
Input:  x = 5, target = 501
Output: 8
```

---

## Constraints

- `2 <= x <= 100`
- `1 <= target <= 2 * 10^8`
