# 873. Length of Longest Fibonacci Subsequence

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

---

## Problem Statement

A sequence `x1, x2, ..., xn` is Fibonacci-like if:
- `n >= 3`
- `xi + xi+1 == xi+2` for all `i + 2 <= n`

Given a strictly increasing array `arr` of positive integers, return the length of the longest Fibonacci-like subsequence of `arr`. If one does not exist, return `0`.

---

## Examples

**Example 1:**
```
Input:  arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: [1,2,3,5,8]
```

**Example 2:**
```
Input:  arr = [1,3,7,11,12,14,18]
Output: 3
Explanation: [1,11,12], [3,11,14], or [7,11,18]
```

---

## Constraints

- `3 <= arr.length <= 1000`
- `1 <= arr[i] < arr[i + 1] <= 10^9`
