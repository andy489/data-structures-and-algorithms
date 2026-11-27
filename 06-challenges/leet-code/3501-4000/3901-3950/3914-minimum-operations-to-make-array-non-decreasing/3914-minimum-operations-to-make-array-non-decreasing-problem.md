# 3914. Minimum Operations to Make Array Non Decreasing

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/

## Problem

You are given an integer array `nums` of length `n`.

In one operation, you may choose any **subarray** `nums[l..r]` and **increase** each element in that **subarray** by `x`, where `x` is any **positive** integer.

Return the **minimum** possible **sum** of the values of `x` across all operations required to make the array **non-decreasing**.

An array is **non-decreasing** if `nums[i] <= nums[i+1]` for all `0 <= i < n-1`.

## Examples

**Example 1:**
```
Input: nums = [3,3,2,1]
Output: 2

Explanation:
- Choose subarray [2..3] and add x=1 -> [3,3,3,2]
- Choose subarray [3..3] and add x=1 -> [3,3,3,3]
Total = 1 + 1 = 2.
```

**Example 2:**
```
Input: nums = [5,1,2,3]
Output: 4

Explanation:
- Choose subarray [1..3] and add x=4 -> [5,5,6,7]
Total = 4.
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
