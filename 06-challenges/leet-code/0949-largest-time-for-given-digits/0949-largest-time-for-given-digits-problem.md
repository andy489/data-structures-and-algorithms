# 949. Largest Time for Given Digits

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-time-for-given-digits/

---

## Problem Statement

Given an array `arr` of 4 digits, find the **latest** 24-hour time that can be made using each digit **exactly once**.

24-hour times are formatted as `"HH:MM"`, where `HH` is between `00` and `23`, and `MM` is between `00` and `59`. The earliest 24-hour time is `00:00`, and the latest is `23:59`.

Return *the latest 24-hour time in `"HH:MM"` format*. If no valid time can be made, return an empty string.

---

## Examples

**Example 1:**
```
Input:  arr = [1,2,3,4]
Output: "23:41"
```

**Example 2:**
```
Input:  arr = [5,5,5,5]
Output: ""
```

---

## Constraints

- `arr.length == 4`
- `0 <= arr[i] <= 9`
