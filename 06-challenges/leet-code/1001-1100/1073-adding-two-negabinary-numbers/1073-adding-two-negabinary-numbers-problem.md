# 1073. Adding Two Negabinary Numbers

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/adding-two-negabinary-numbers/

---

## Problem Statement

Given two numbers `arr1` and `arr2` in base **-2**, return the result of adding them together.

Each number is given in *array format*: as an array of 0s and 1s, from most significant bit to least significant bit. For example, `arr = [1,1,0,1]` represents the number `(-2)^3 + (-2)^2 + (-2)^0 = -3`. A number `N` is a **negabinary** representation if `...` Return the result in the same format.

---

## Examples

**Example 1:**
```
Input:  arr1 = [1,1,1,1,1], arr2 = [1,0,1]
Output: [1,0,0,0,0]
```

**Example 2:**
```
Input:  arr1 = [0], arr2 = [0]
Output: [0]
```

---

## Constraints

- `1 <= arr1.length, arr2.length <= 1000`
- `arr1[i]` and `arr2[i]` are `0` or `1`
- `arr1` and `arr2` have no leading zeros
