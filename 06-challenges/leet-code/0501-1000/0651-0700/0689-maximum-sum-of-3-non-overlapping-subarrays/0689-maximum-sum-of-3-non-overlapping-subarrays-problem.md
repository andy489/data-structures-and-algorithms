# 689. Maximum Sum of 3 Non-Overlapping Subarrays

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, find three non-overlapping subarrays of length `k` with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (**0-indexed**). If there are multiple answers, return the lexicographically smallest one.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1,2], [2,6], [7,5] correspond to starting indices 0, 3, 5.
```

**Example 2:**
```
Input:  nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
```

---

## Constraints

- `1 <= nums.length <= 2 * 10⁴`
- `1 <= nums[i] < 2^16`
- `1 <= k <= floor(nums.length / 3)`
