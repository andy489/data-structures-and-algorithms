# 768. Max Chunks To Make Sorted II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

---

## Problem Statement

You are given an integer array `arr`.

We split `arr` into some number of **chunks** (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the **largest** number of chunks we can make to sort the array.

---

## Examples

**Example 1:**
```
Input:  arr = [5,4,3,2,1]
Output: 1
```

**Example 2:**
```
Input:  arr = [2,1,3,4,4]
Output: 4
```

---

## Constraints

- `1 <= arr.length <= 2000`
- `0 <= arr[i] <= 10^8`
