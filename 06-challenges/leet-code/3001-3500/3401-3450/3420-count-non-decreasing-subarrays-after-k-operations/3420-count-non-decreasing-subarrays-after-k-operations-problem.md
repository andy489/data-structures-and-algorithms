# 3420. Count Non-Decreasing Subarrays After K Operations

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

## Problem

You are given an array nums of n integers and an integer k.

For each subarray of nums, you can apply up to k operations on it. In each operation, you increment any element of the subarray by 1.

Note that each subarray is considered independently, meaning changes made to one subarray do not persist to another.

Return the number of subarrays that you can make non-decreasing after performing at most k operations.

An array is said to be non-decreasing if each element is greater than or equal to its previous element, if it exists.

## Examples

**Example 1:**

Input: nums = [6,3,1,2,4,4], k = 7
Output: 17

Explanation: Out of all 21 possible subarrays, only [6,3,1], [6,3,1,2], [6,3,1,2,4], and [6,3,1,2,4,4] cannot be made non-decreasing. 21 - 4 = 17.

**Example 2:**

Input: nums = [6,3,1,3,6], k = 4
Output: 12

## Constraints

- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^9
- 1 <= k <= 10^9
