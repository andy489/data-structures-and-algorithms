# 3427. Sum of Variable Length Subarrays

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/sum-of-variable-length-subarrays/

## Problem

You are given an integer array nums of size n. For each index i where 0 <= i < n, define a subarray nums[start ... i] where start = max(0, i - nums[i]).

Return the total sum of all elements from the subarray defined for each index in the array.

## Examples

**Example 1:**

Input: nums = [2,3,1]
Output: 11

Explanation:
- i=0: nums[0] = [2], sum = 2
- i=1: nums[0..1] = [2,3], sum = 5
- i=2: nums[1..2] = [3,1], sum = 4
Total = 11

**Example 2:**

Input: nums = [3,1,1,2]
Output: 13

## Constraints

- 1 <= n == nums.length <= 100
- 1 <= nums[i] <= 1000
