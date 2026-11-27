# 3428. Maximum and Minimum Sums of at Most Size K Subsequences

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/

## Problem

You are given an integer array nums and a positive integer k. Return the sum of the maximum and minimum elements of all subsequences of nums with at most k elements.

Since the answer may be very large, return it modulo 10^9 + 7.

## Examples

**Example 1:**

Input: nums = [1,2,3], k = 2
Output: 24

**Example 2:**

Input: nums = [5,0,6], k = 1
Output: 22

**Example 3:**

Input: nums = [1,1,1], k = 2
Output: 12

## Constraints

- 1 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^9
- 1 <= k <= min(70, nums.length)
