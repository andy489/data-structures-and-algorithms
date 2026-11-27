# 969. Pancake Sorting

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pancake-sorting/

---

## Problem Statement

Given an array of integers `arr`, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:
- Choose an integer `k` where `1 <= k <= arr.length`.
- Reverse the sub-array `arr[0...k-1]` (0-indexed).

Return an array of the `k`-values corresponding to a sequence of pancake flips that sort `arr`. Any valid answer that sorts the array within `10 * arr.length` flips will be judged as correct.

---

## Examples

**Example 1:**
```
Input:  arr = [3,2,4,1]
Output: [4,2,4,3]
```

**Example 2:**
```
Input:  arr = [1,2,3]
Output: []
```

---

## Constraints

- `1 <= arr.length <= 100`
- `1 <= arr[i] <= arr.length`
- All integers in `arr` are unique.
