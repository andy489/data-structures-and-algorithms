# 972. Equal Rational Numbers

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/equal-rational-numbers/

---

## Problem Statement

Given two strings `s` and `t`, each of which represents a non-negative rational number, return `true` if and only if they represent the same number. The strings may use parentheses to denote the repeating part of the rational number.

A rational number can be represented using up to three parts: `<IntegerPart>`, `<NonRepeatingPart>`, and `<RepeatingPart>`. The number will be represented in one of the following three ways:

- `<IntegerPart>` (e.g., `0`, `12`, `123`)
- `<IntegerPart><.><NonRepeatingPart>` (e.g., `0.5`, `2.12`)
- `<IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>` (e.g., `0.1(6)`, `0.9(9)`, `0.(52)`)

---

## Examples

**Example 1:**
```
Input:  s = "0.(52)", t = "0.5(25)"
Output: true
```

**Example 2:**
```
Input:  s = "0.1666(6)", t = "0.166(66)"
Output: true
```

---

## Constraints

- Each part consists only of digits.
- The `<IntegerPart>` does not have leading zeros (except for the zero itself).
- `1 <= <IntegerPart>.length <= 4`
- `0 <= <NonRepeatingPart>.length <= 4`
- `1 <= <RepeatingPart>.length <= 4`
