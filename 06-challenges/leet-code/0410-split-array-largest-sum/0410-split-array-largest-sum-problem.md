# 410. Split Array Largest Sum

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/split-array-largest-sum/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty subarrays such that the largest subarray sum is minimized.

Return the minimized largest sum of the split.

---

## Examples

**Example 1:**
```
Input:  nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: Split into [7,2,5] and [10,8]; the largest sum is max(14,18) = 18. This is the minimum possible.
```

**Example 2:**
```
Input:  nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: Split into [1,2,3,4] and [5]; the largest sum is 9.
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 10^6`
- `1 <= k <= min(50, nums.length)`
