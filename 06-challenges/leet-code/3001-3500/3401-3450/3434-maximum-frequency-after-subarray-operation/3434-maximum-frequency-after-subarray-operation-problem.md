# 3434. Maximum Frequency After Subarray Operation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-frequency-after-subarray-operation/

## Problem

You are given an array `nums` of length `n`. You are also given an integer `k`.

You perform the following operation on `nums` once:

- Select a subarray `nums[i..j]` where `0 <= i <= j <= n - 1`.
- Select an integer `x` and add `x` to all the elements in `nums[i..j]`.

Find the maximum frequency of the value `k` after the operation.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5,6], k = 1
Output: 2
```

**Example 2:**
```
Input: nums = [10,2,3,4,5,5,4,3,2,2], k = 10
Output: 4
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 50`
- `1 <= k <= 50`
