# 1819. Number of Different Subsequences GCDs

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-different-subsequences-gcds/

---

## Problem Statement

You are given an array `nums` that consists of positive integers.

The **GCD** of a sequence of numbers is defined as the greatest integer that divides all the numbers in the sequence evenly.

- For example, the GCD of the sequence `[4,6,16]` is `2`.

A **subsequence** of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

- For example, `[2,5,10]` is a subsequence of `[1,2,1,2,5,10]`.

Return the **number of different GCDs** among all **non-empty** subsequences of `nums`.

---

## Examples

**Example 1:**
```
Input: nums = [6,10,3]
Output: 5
Explanation: The figure shows all the non-empty subsequences and their GCDs.
The different GCDs are 1, 2, 3, 5, 6, 10 — wait, actually for nums=[6,10,3]:
Subsequences and GCDs: {6}->6, {10}->10, {3}->3, {6,10}->2, {6,3}->3, {10,3}->1, {6,10,3}->1.
Distinct GCDs = {1,2,3,6,10} = 5.
```

**Example 2:**
```
Input: nums = [5,15,40,5,6]
Output: 7
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 2 * 10^5`
