# 3432. Count Partitions with Even Sum Difference

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-partitions-with-even-sum-difference/

## Problem

You are given an integer array `nums` of length `n`.

A partition is defined as an index `i` where `0 <= i < n - 1`, splitting the array into two non-empty subarrays such that:

- Left subarray contains indices `[0, i]`.
- Right subarray contains indices `[i + 1, n - 1]`.

Return the number of partitions where the difference between the sum of the left and right subarrays is even.

## Examples

**Example 1:**
```
Input: nums = [10,10,3,7,6]
Output: 4
```

**Example 2:**
```
Input: nums = [1,2,2]
Output: 0
```

**Example 3:**
```
Input: nums = [2,4,6,8]
Output: 3
```

## Constraints

- `2 <= n == nums.length <= 100`
- `1 <= nums[i] <= 100`
