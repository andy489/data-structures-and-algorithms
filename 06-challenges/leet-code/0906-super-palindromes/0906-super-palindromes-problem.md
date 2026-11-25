# 906. Super Palindromes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/super-palindromes/

---

## Problem Statement

Let's say a positive integer is a **super-palindrome** if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers `left` and `right` represented as strings, return the number of **super-palindromes** integers in the inclusive range `[left, right]`.

---

## Examples

**Example 1:**
```
Input:  left = "4", right = "9"
Output: 2
```

**Example 2:**
```
Input:  left = "1", right = "1000000000"
Output: 4
```

---

## Constraints

- `1 <= left.length, right.length <= 18`
- `left` and `right` consist of only digits.
- `left` and `right` don't have leading zeros.
- `left` and `right` represent integers in the range `[1, 10^18]`.
- `left <= right`
