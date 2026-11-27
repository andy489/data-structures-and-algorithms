# 3409. Longest Subsequence With Decreasing Adjacent Difference

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/

## Problem

You are given an array of integers nums. Find the length of the longest subsequence such that the absolute differences between consecutive elements form a non-increasing sequence.

For a subsequence seq0, seq1, ..., seqm: |seq1-seq0| >= |seq2-seq1| >= ... >= |seqm-seqm-1|.

## Examples

**Example 1:**

Input: nums = [16,6,3]
Output: 3

Explanation: [16,6,3] has differences [10,3].

**Example 2:**

Input: nums = [6,5,3,4,2,1]
Output: 4

Explanation: [6,4,2,1] has differences [2,2,1].

**Example 3:**

Input: nums = [10,20,10,19,10,20]
Output: 5

Explanation: [10,20,10,19,10] has differences [10,10,9,9].

## Constraints

- 2 <= nums.length <= 10^4
- 1 <= nums[i] <= 300
