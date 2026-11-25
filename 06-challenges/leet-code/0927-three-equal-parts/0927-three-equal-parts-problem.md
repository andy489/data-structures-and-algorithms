# 927. Three Equal Parts

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/three-equal-parts/

---

## Problem Statement

You are given an array `arr` which consists of only zeros and ones, divide the array into **three non-empty parts** such that all of these parts represent the same binary value.

If it is possible, return any `[i, j]` with `i + 1 < j`, such that:
- `arr[0], ..., arr[i]` is the first part,
- `arr[i + 1], ..., arr[j - 1]` is the second part, and
- `arr[j], ..., arr[arr.length - 1]` is the third part.
- All three parts have equal binary values.

If it is not possible, return `[-1, -1]`.

---

## Examples

**Example 1:**
```
Input:  arr = [1,0,1,0,1]
Output: [0,3]
```

**Example 2:**
```
Input:  arr = [1,1,0,1,1]
Output: [-1,-1]
```

---

## Constraints

- `3 <= arr.length <= 3 * 10^4`
- `arr[i]` is `0` or `1`.
