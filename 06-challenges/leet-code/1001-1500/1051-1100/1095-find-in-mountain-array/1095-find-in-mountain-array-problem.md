# 1095. Find in Mountain Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-in-mountain-array/

---

## Problem Statement

You may recall that an array `arr` is a **mountain array** if and only if `arr[0] < arr[1] < ... < arr[k]` and `arr[k] > arr[k+1] > ... > arr[arr.length - 1]` for some peak index `k`.

Given a mountain array `mountainArr`, and an integer `target`, return the **minimum index** such that `mountainArr.get(index) == target`. If such an index does not exist, return `-1`.

**You cannot access the mountain array directly.** You may only access the array using a `MountainArray` interface.

---

## Examples

**Example 1:**
```
Input:  array = [1,2,3,4,5,3,1], target = 3
Output: 2
```

**Example 2:**
```
Input:  array = [0,1,2,4,2,1,0], target = 3
Output: -1
```

---

## Constraints

- `3 <= mountain_arr.length() <= 10^4`
- `0 <= target <= 10^9`
- `0 <= mountain_arr.get(index) <= 10^9`
