# 537. Complex Number Multiplication

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/complex-number-multiplication/

---

## Problem Statement

A **complex number** can be represented as a string on the form `"real+imaginaryi"` where:
- `real` is the real part and is an integer in the range `[-100, 100]`.
- `imaginary` is the imaginary part and is an integer in the range `[-100, 100]`.
- `i^2 == -1`.

Given two complex numbers `num1` and `num2` as strings, return a string of the complex number that represents their multiplications.

---

## Examples

**Example 1:**
```
Input:  num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i + i + i^2 = 1 + 2i - 1 = 0 + 2i
```

**Example 2:**
```
Input:  num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 - i - i + i^2 = 1 - 2i - 1 = 0 - 2i
```

---

## Constraints

- `num1` and `num2` are valid complex numbers.
