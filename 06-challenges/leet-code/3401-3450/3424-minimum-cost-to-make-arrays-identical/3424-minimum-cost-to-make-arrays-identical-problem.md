# 3424. Minimum Cost to Make Arrays Identical

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

## Problem

You are given two integer arrays arr and brr of length n, and an integer k. You can perform the following operations on arr any number of times:

1. Split arr into any number of contiguous subarrays and rearrange these subarrays in any order. This operation has a fixed cost of k.
2. Choose any element in arr and add or subtract a positive integer x to it. The cost of this operation is x.

Return the minimum total cost to make arr equal to brr.

## Examples

**Example 1:**

Input: arr = [-7,9,5], brr = [7,-2,-5], k = 2
Output: 13

**Example 2:**

Input: arr = [2,1], brr = [2,1], k = 0
Output: 0

## Constraints

- 1 <= arr.length == brr.length <= 10^5
- 0 <= k <= 2 * 10^10
- -10^5 <= arr[i] <= 10^5
- -10^5 <= brr[i] <= 10^5
