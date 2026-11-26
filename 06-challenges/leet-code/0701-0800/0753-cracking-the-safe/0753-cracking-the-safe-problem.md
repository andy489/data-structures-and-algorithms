# 753. Cracking the Safe

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cracking-the-safe/

---

## Problem Statement

There is a safe protected by a password. The password is a sequence of `n` digits where each digit can be in the range `[0, k - 1]`.

The safe has a peculiar way of checking the password: it checks the **last** `n` digits entered each time you type a digit. For example, the correct password is `"345"`, and you type in `"012345"`, the safe opens because the last 3 digits are `"345"`.

Return any string of **minimum length** that will unlock the safe **at some point** during the typing of the string, or return the string if it already exists.

---

## Examples

**Example 1:**
```
Input:  n = 1, k = 2
Output: "01"
```

**Example 2:**
```
Input:  n = 2, k = 2
Output: "00110"
```

---

## Constraints

- `1 <= n <= 4`
- `1 <= k <= 10`
- `1 <= k^n <= 4096`
