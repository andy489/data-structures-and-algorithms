# 769. Max Chunks To Make Sorted

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-chunks-to-make-sorted/

---

## Problem Statement

You are given an integer array `arr` of length `n` that represents a permutation of the integers in the range `[0, n - 1]`.

We split `arr` into some number of **chunks** (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the **largest** number of chunks we can make to sort the array.

---

## Examples

**Example 1:**
```
Input:  arr = [4,3,2,1,0]
Output: 1
```

**Example 2:**
```
Input:  arr = [1,0,2,3,4]
Output: 4
```

---

## Constraints

- `n == arr.length`
- `1 <= n <= 10`
- `0 <= arr[i] < n`
- All the integers of `arr` are **unique**.
