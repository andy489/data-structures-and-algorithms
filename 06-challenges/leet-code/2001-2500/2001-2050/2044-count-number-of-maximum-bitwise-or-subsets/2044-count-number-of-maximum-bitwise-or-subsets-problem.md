# 2044. Count Number of Maximum Bitwise-OR Subsets

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

---

## Problem Statement

Given an integer array `nums`, find the **maximum** possible bitwise OR of a subset and return the **number of different non-empty subsets** with that maximum bitwise OR.

---

## Examples

**Example 1:**
```
Input:  nums = [3,1]
Output: 2
```
Explanation: Max OR = 3. Subsets with OR 3: {3}, {1,3}.

**Example 2:**
```
Input:  nums = [2,2,2]
Output: 7
```
Explanation: Max OR = 2. All 7 non-empty subsets.

**Example 3:**
```
Input:  nums = [3,2,1,5]
Output: 6
```
Explanation: Max OR = 7. 6 subsets.

---

## Constraints

- `1 <= nums.length <= 16`
- `1 <= nums[i] <= 10^5`
