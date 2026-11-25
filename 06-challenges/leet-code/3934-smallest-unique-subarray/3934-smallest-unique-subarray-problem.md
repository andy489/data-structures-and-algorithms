# 3934. Smallest Unique Subarray

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

---

## Problem Statement

Given an integer array `nums`, find the minimum length of a subarray that appears exactly once in the entire array. Two subarrays are identical if they share the same length and elements in matching positions.

---

## Examples

**Example 1:**
```
Input:  nums = [3,3,3]
Output: 3
```
Explanation: Length-1 subarrays `[3]` appear 3 times; length-2 subarrays `[3,3]` appear twice; only `[3,3,3]` is unique.

**Example 2:**
```
Input:  nums = [2,1,2,3,3]
Output: 1
```
Explanation: Among length-1 subarrays, `[1]` appears only once.

**Example 3:**
```
Input:  nums = [1,1,2,2,1]
Output: 2
```
Explanation: All four distinct length-2 subarrays appear exactly once.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
