# 1442. Count Triplets That Can Form Two Arrays Of Equal Xor

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

---

## Problem Statement

Count triplets (i, j, k) where `0 <= i < j <= k < n` and `xor(arr[i..j-1]) == xor(arr[j..k])`.

---

## Examples

**Example 1:**
```
Input:  arr=[2,3,1,6,7]
Output: 4
```

**Example 2:**
```
Input:  arr=[1,1,1,1,1]
Output: 10
```

---

## Constraints

- `1 <= arr.length <= 300`
- `1 <= arr[i] <= 10^8`
