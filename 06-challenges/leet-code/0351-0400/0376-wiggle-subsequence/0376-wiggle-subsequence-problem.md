# 376. Wiggle Subsequence

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/wiggle-subsequence/

---

## Problem Statement

A **wiggle sequence** is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

Given an integer array `nums`, return the length of the longest **wiggle subsequence** of `nums`.

A **subsequence** is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

---

## Examples

**Example 1:**
```
Input:  nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
```

**Example 2:**
```
Input:  nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: One valid wiggle subsequence: [1, 17, 10, 13, 10, 16, 8].
```

**Example 3:**
```
Input:  nums = [1,2,3,4,5,6,7,8,9]
Output: 2
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`

**Follow-up:** Could you solve this in O(n) time?
