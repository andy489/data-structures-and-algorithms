# 3065. Minimum Operations To Exceed Threshold Value I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

---

## Problem Statement

You are given a 0-indexed integer array `nums` and an integer `k`.

In one operation, you can remove an element from `nums`.

Return the minimum number of operations required so that all remaining elements of `nums` are greater than or equal to `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,11,10,1,3], k = 10
Output: 3
```
Explanation: Remove 2, 1, 3 (3 operations) so remaining are [11,10] both >= 10.

**Example 2:**
```
Input:  nums = [1,1,2,4,9], k = 1
Output: 0
```
Explanation: All elements already >= 1.

---

## Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= 10^9`
