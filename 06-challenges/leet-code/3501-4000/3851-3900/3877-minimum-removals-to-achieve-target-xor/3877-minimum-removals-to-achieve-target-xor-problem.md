# 3877. Minimum Removals to Achieve Target XOR

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/

## Problem

You are given an integer array `nums` and an integer `target`.

You may remove **any** number of elements from `nums` (possibly zero).

Return the **minimum** number of removals required so that the **bitwise XOR** of the remaining elements equals `target`. If it is impossible to achieve `target`, return -1.

The bitwise XOR of an empty array is 0.

## Examples

**Example 1:**
```
Input: nums = [1,2,3], target = 2
Output: 1
Explanation:
- Removing nums[1] = 2 leaves [1, 3]. XOR = 1 ^ 3 = 2.
```

**Example 2:**
```
Input: nums = [2,4], target = 1
Output: -1
```

**Example 3:**
```
Input: nums = [7], target = 7
Output: 0
```

## Constraints

- `1 <= nums.length <= 40`
- `0 <= nums[i] <= 10^4`
- `0 <= target <= 10^4`
