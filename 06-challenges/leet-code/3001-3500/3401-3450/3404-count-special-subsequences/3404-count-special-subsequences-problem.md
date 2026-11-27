# 3404. Count Special Subsequences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-special-subsequences/

## Problem

You are given an array nums consisting of positive integers.

A special subsequence is defined as a subsequence of length 4, represented by indices (p, q, r, s), where p < q < r < s. This subsequence must satisfy the following conditions:

- nums[p] * nums[r] == nums[q] * nums[s]
- There must be at least one element between each pair of indices. In other words, q - p > 1, r - q > 1 and s - r > 1.

Return the number of different special subsequences in nums.

## Examples

**Example 1:**

Input: nums = [1,2,3,4,3,6,1]
Output: 1

Explanation:
There is one special subsequence in nums.
- (p, q, r, s) = (0, 2, 4, 6): elements (1, 3, 3, 1). nums[p]*nums[r] = 1*3 = 3, nums[q]*nums[s] = 3*1 = 3.

**Example 2:**

Input: nums = [3,4,3,4,3,4,3,4]
Output: 3

Explanation:
There are three special subsequences:
- (0, 2, 4, 6): (3,3,3,3). 9 == 9.
- (1, 3, 5, 7): (4,4,4,4). 16 == 16.
- (0, 2, 5, 7): (3,3,4,4). 12 == 12.

## Constraints

- 7 <= nums.length <= 1000
- 1 <= nums[i] <= 1000
