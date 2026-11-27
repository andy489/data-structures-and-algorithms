# 3397. Maximum Number of Distinct Elements After Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`.

You are allowed to perform at most one operation per element: add any integer in the range `[-k, k]` to that element.

Return the **maximum number of distinct elements** in the array after performing the operations.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,2,3,3,4], k = 2
Output: 6
```
Explanation: Transform to `[-1, 0, 1, 2, 3, 4]` — all distinct.

**Example 2:**
```
Input:  nums = [4,4,4,4], k = 1
Output: 3
```
Explanation: Ranges are `[3,5]` for each; can assign 3, 4, 5 — fourth cannot get a unique value.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `0 <= k <= 10^9`
