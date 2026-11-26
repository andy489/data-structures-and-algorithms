# 1238. Circular Permutation in Binary Representation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circular-permutation-in-binary-representation/

---

## Problem Statement

Given 2 integers `n` and `start`. Your task is return any permutation `p` of `(0,1,2.....,2^n -1)` such that there is no integer `i` where `0 <= i < 2^n - 1` with `p[i]` and `p[i+1]` differ by more than 1 bit in their binary representation. Also `p[0]` and `p[2^n - 1]` must differ by exactly 1 bit.

---

## Examples

**Example 1:**
```
Input:  n = 2, start = 3
Output: [3,2,0,1]
```

---

## Constraints

- `1 <= n <= 16`
- `0 <= start < 2^n`
