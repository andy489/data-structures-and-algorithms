# 1419. Minimum Number Of Frogs Croaking

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-frogs-croaking/

---

## Problem Statement

Given string `croakOfFrogs`, validate it's a mix of valid 'croak' sequences. Return min simultaneous frogs, or -1 if invalid.

---

## Examples

**Example 1:**
```
Input:  croakOfFrogs = "croakcroak"
Output: 1
```

**Example 2:**
```
Input:  croakOfFrogs = "crcoakroak"
Output: 2
```

**Example 3:**
```
Input:  croakOfFrogs = "croakcrook"
Output: -1
```

---

## Constraints

- `1 <= croakOfFrogs.length <= 10^5`
- `croakOfFrogs[i] is 'c', 'r', 'o', 'a', or 'k'`
