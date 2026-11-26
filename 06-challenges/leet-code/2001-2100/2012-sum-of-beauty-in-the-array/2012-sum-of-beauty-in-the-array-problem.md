# 2012. Sum of Beauty in the Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-beauty-in-the-array/

---

## Problem Statement

Given a 0-indexed integer array `nums`, for each index `i` from `1` to `nums.length - 2`, the **beauty** of `nums[i]` equals:
- **2**, if `nums[j] < nums[i] < nums[k]` for all `0 <= j < i` and `i < k <= n - 1`.
- **1**, if `nums[i - 1] < nums[i] < nums[i + 1]`.
- **0** otherwise.

Return the **sum** of beauty of all `nums[i]` for `1 <= i <= nums.length - 2`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3]
Output: 2
```
Explanation: Index 1 has beauty 2.

**Example 2:**
```
Input:  nums = [2,4,6,4]
Output: 1
```

**Example 3:**
```
Input:  nums = [3,2,1]
Output: 0
```

---

## Constraints

- `3 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
