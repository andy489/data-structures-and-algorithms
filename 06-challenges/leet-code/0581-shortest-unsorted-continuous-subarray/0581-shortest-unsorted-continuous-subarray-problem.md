# 581. Shortest Unsorted Continuous Subarray

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

---

## Problem Statement

Given an integer array `nums`, you need to find one **continuous subarray** such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the **shortest** such subarray and output its **length**.

---

## Examples

**Example 1:**
```
Input:  nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: Sort nums[1..5] = [6,4,8,10,9] → whole array sorted.
```

**Example 2:**
```
Input:  nums = [1,2,3,4]
Output: 0
```

**Example 3:**
```
Input:  nums = [1]
Output: 0
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^5 <= nums[i] <= 10^5`
