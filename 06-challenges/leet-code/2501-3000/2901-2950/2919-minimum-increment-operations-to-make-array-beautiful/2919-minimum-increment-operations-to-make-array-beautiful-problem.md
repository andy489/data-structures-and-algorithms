# 2919. Minimum Increment Operations to Make Array Beautiful

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/

---

## Problem Statement

You are given a **0-indexed** integer array `nums` having length `n`, and an integer `k`.

You can perform the **increment** operation any number of times: choose an index `i` and increase `nums[i]` by 1.

An array is considered **beautiful** if, for **every subarray** with a size of 3 or **more**, its **maximum** element is **greater than or equal** to `k`.

Return an integer denoting the **minimum** number of increment operations needed to make `nums` **beautiful**.

---

## Examples

**Example 1:**
```
Input: nums = [2,3,0,0,2], k = 4
Output: 3
```

**Example 2:**
```
Input: nums = [0,1,3,3], k = 5
Output: 2
```

**Example 3:**
```
Input: nums = [1,1,2], k = 1
Output: 0
```

---

## Constraints

- `3 <= n == nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`
- `0 <= k <= 10^9`
