# 564. Find the Closest Palindrome

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-closest-palindrome/

---

## Problem Statement

Given a string `n` representing an integer, return *the closest integer (not including itself) which is a palindrome*. If there is a tie, return the **smaller** one.

The closest is defined as the absolute difference minimized between two integers.

---

## Examples

**Example 1:**
```
Input:  n = "123"
Output: "121"
```

**Example 2:**
```
Input:  n = "1"
Output: "0"
```

---

## Constraints

- `1 <= n.length <= 18`
- `n` consists of only digits
- `n` does not have leading zeros except for `"0"` itself
