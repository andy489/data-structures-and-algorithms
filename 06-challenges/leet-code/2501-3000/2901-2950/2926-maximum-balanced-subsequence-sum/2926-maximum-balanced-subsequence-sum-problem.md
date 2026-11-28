# 2926. Maximum Balanced Subsequence Sum

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-balanced-subsequence-sum/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`.

A **subsequence** of `nums` having length `k` and consisting of **indices** `i0 < i1 < ... < ik-1` is **balanced** if the following holds:

- `nums[ij] - nums[ij-1] >= ij - ij-1`, for every `j` in the range `[1, k - 1]`.

A **subsequence** of `nums` having length `1` is considered balanced.

Return an integer denoting the **maximum** possible **sum of elements** in a **balanced** subsequence of `nums`.

A **subsequence** of an array is a new **non-empty** array that is formed from the original array by deleting some (**possibly none**) of the elements without disturbing the relative positions of the remaining elements.

---

## Examples

**Example 1:**
```
Input: nums = [3,3,5,6]
Output: 14
Explanation: In this example, the subsequence [3,5,6] consisting of indices 0, 2, and 3 can be selected.
nums[2] - nums[0] >= 2 - 0.
nums[3] - nums[2] >= 3 - 2.
Hence, it is a balanced subsequence, and its sum is 14.
```

**Example 2:**
```
Input: nums = [5,-1,-3,8]
Output: 13
Explanation: The subsequence [5,8] consisting of indices 0 and 3 can be selected.
nums[3] - nums[0] >= 3 - 0.
Hence, it is a balanced subsequence, and its sum is 13.
```

**Example 3:**
```
Input: nums = [-2,-1]
Output: -1
Explanation: The subsequence [-1] can be selected.
It is a balanced subsequence, and its sum is the maximum.
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
