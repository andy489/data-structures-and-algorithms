# 3410. Maximize Subarray Sum After Removing All Occurrences of One Element

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/

## Problem

You are given an integer array nums. You can do the following operation on the array at most once:

- Choose any integer x such that nums remains non-empty on removing all occurrences of x.
- Remove all occurrences of x from the array.

Return the maximum subarray sum across all possible resulting arrays.

## Examples

**Example 1:**

Input: nums = [-3,2,-2,-1,3,-2,3]
Output: 7

Explanation: Deleting all -2's gives nums = [-3,2,-1,3,3], maximum subarray sum = 2+(-1)+3+3 = 7.

**Example 2:**

Input: nums = [1,2,3,4]
Output: 10

Explanation: No operation needed; maximum subarray sum is 1+2+3+4 = 10.

## Constraints

- 1 <= nums.length <= 10^5
- -10^6 <= nums[i] <= 10^6
