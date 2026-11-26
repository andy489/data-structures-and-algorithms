# 1416. Restore The Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/restore-the-array/

---

## Problem Statement

A program was printing an array of positive integers from `1` to `10^9`, but all spaces and commas were removed. Given string `s` and max value `k`, return the number of ways to restore the array, mod 10^9+7.

---

## Examples

**Example 1:**
```
Input:  s="1000",k=10000
Output: 1
```

**Example 2:**
```
Input:  s="1000",k=10
Output: 0
```

**Example 3:**
```
Input:  s="1317",k=2000
Output: 8
```

---

## Constraints

- `1 <= k <= 10^9`
- `1 <= s.length <= 10^5`
- `s consists of digits only`
- `s doesn't have leading zeros`
