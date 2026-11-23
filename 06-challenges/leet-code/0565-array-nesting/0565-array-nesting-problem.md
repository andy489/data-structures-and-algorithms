# 565. Array Nesting

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/array-nesting/

---

## Problem Statement

You are given an integer array `nums` of length `n` where `nums` is a permutation of the numbers in the range `[0, n - 1]`.

You should build a set `s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ...}` subjected to the following rule:

The first element in `s[k]` starts with the selection of the element `nums[k]` of `index = k`. The next element in `s[k]` should be `nums[nums[k]]`, and then `nums[nums[nums[k]]]`, and so on. We stop adding right before a duplicate element occurs in `s[k]`.

Return *the longest length of a set* `s[k]`.

---

## Examples

**Example 1:**
```
Input:  nums = [5,4,0,3,1,6,2]
Output: 4
```
Explanation: `s[0] = {5, 6, 2, 0}` has length 4.

**Example 2:**
```
Input:  nums = [0,2,1]
Output: 2
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] < nums.length`
- All the values of `nums` are **unique**
