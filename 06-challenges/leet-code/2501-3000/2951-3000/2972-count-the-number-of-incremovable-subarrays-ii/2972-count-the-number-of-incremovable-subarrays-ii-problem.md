# 2972. Count the Number of Incremovable Subarrays II

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/

## Problem

You are given a 0-indexed array of positive integers nums.

A subarray of nums is called **incremovable** if nums becomes strictly increasing on removing the subarray. For example, the subarray [3, 4] is an incremovable subarray of [5, 3, 4, 6, 7] because removing this subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.

Return the total number of incremovable subarrays of nums.

Note that an empty array is considered strictly increasing.

A subarray is a contiguous non-empty sequence of elements within an array.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: 10
```

**Example 2:**
```
Input: nums = [6,5,7,8]
Output: 7
```

**Example 3:**
```
Input: nums = [8,7,6,6]
Output: 3
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
