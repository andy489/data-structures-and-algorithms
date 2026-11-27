# 1785. Minimum Elements to Add to Form a Given Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/

---

## Problem Statement

You are given an integer array `nums` and two integers `limit` and `goal`. The array `nums` has an interesting property that `abs(nums[i]) <= limit`.

Return the minimum number of elements you need to add to make the sum of the array equal to `goal`. Each added element should have an absolute value at most `limit`.

---

## Examples

**Example 1:**
```
Input: nums = [1,-1,1], limit = 3, goal = -4
Output: 2
Explanation: One possible solution is to add -2 and -3, then the sum becomes 1 + (-1) + 1 + (-2) + (-3) = -4.
```

**Example 2:**
```
Input: nums = [1,-10,9,1], limit = 100, goal = 0
Output: 1
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= limit <= 10^6`
- `-10^9 <= goal <= 10^9`
- `-limit <= nums[i] <= limit`
