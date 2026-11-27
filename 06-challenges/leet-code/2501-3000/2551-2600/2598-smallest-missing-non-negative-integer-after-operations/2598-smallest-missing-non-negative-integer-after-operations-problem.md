# 2598. Smallest Missing Non-negative Integer After Operations

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/

## Problem

You are given a **0-indexed** integer array `nums` and an integer `value`.

In one operation, you can add or subtract `value` from any element of `nums`.

The MEX (minimum excluded) of an array is the smallest missing **non-negative** integer in it.

Return the maximum MEX of `nums` after applying the mentioned operation **any number of times**.

## Examples

**Example 1:**
```
Input: nums = [1,-10,7,13,6,8], value = 5
Output: 4
Explanation: One can achieve this result by applying the following operations:
- Add value to nums[1] twice to make nums = [1,0,7,13,6,8]
- Subtract value from nums[2] once to make nums = [1,0,2,13,6,8]
- Subtract value from nums[3] twice to make nums = [1,0,2,3,6,8]
The MEX of nums is 4.
```

**Example 2:**
```
Input: nums = [1,-10,7,13,6,8], value = 7
Output: 2
Explanation: One can achieve this result by applying the following operations:
- Subtract value from nums[2] once to make nums = [1,-10,0,13,6,8]
The MEX of nums is 2.
```

## Constraints

- `1 <= nums.length, value <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
