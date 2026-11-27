# 665. Non-decreasing Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/non-decreasing-array/

---

## Problem Statement

Given an array `nums` with `n` integers, your task is to check if it could become non-decreasing by modifying **at most one element**.

We define an array is non-decreasing if `nums[i] <= nums[i + 1]` holds for every `i` (0-indexed) such that `(0 <= i <= n - 2)`.

---

## Examples

**Example 1:**
```
Input:  nums = [4,2,3]
Output: true
Explanation: Modify nums[0] to 1 (or less) to make it non-decreasing.
```

**Example 2:**
```
Input:  nums = [4,2,1]
Output: false
Explanation: You need to modify more than one element.
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10⁴`
- `-10⁵ <= nums[i] <= 10⁵`
