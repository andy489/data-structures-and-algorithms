# 813. Largest Sum of Averages

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-sum-of-averages/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`. You can partition the array into at most `k` non-empty adjacent subarrays. The score is the sum of the averages of each subarray. Return the maximum score.

---

## Examples

**Example 1:**
```
Input:  nums = [9,1,2,3,9], k = 3
Output: 20.00000
Explanation: [9], [1,2,3], [9] gives 9 + 2 + 9 = 20.
```

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`
