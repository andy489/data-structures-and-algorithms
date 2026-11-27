# 3908. Valid Digit Number

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/valid-digit-number/

## Problem

You are given an integer `n` and a digit `x`.

A number is considered **valid** if:
- It contains **at least one** occurrence of digit `x`, and
- It **does not start** with digit `x`.

Return `true` if `n` is **valid**, otherwise return `false`.

## Examples

**Example 1:**
```
Input: n = 101, x = 0
Output: true

Explanation: The number contains digit 0 at index 1. It does not start with 0.
```

**Example 2:**
```
Input: n = 232, x = 2
Output: false

Explanation: The number starts with 2, which violates the condition.
```

**Example 3:**
```
Input: n = 5, x = 1
Output: false

Explanation: The number does not contain digit 1.
```

## Constraints

- `0 <= n <= 10^5`
- `0 <= x <= 9`
