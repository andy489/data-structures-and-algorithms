# 1846. Maximum Element After Decreasing and Rearranging

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

---

## Problem Statement

You are given an integer array `arr`. You can perform the following operations as many times as you want:

- **Decrease** the value of any element of `arr` to a smaller positive integer.
- **Rearrange** the elements of `arr` in any order you want.

Return *the* **maximum** *possible value of an element in* `arr` *after performing the operations such that the array satisfies the following conditions:*

- The value of the first element **must** be `1`.
- The absolute difference between any 2 adjacent elements must be **less than or equal to** `1`.

---

## Examples

**Example 1:**
```
Input: arr = [2,2,1,2,1]
Output: 2
```

**Example 2:**
```
Input: arr = [100,1,1000]
Output: 3
```

**Example 3:**
```
Input: arr = [1,2,3,4,5]
Output: 5
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^9`
