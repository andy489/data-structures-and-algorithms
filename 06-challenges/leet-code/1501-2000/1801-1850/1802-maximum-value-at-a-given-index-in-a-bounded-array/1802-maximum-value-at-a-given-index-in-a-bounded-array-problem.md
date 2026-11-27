# 1802. Maximum Value at a Given Index in a Bounded Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

---

## Problem Statement

You are given three positive integers: `n`, `index`, and `maxSum`. Construct an array `nums` (0-indexed) that satisfies all of the following conditions:

- `nums.length == n`
- `nums[i]` is a positive integer where `0 <= i < n`
- `abs(nums[i] - nums[i+1]) <= 1` for each valid `i`
- The sum of all elements of `nums` does not exceed `maxSum`
- `nums[index]` is **maximized**

Return `nums[index]` of the constructed array.

---

## Examples

**Example 1:**
```
Input: n = 4, index = 2, maxSum = 6
Output: 2
Explanation: nums = [1, 2, 2, 1] satisfies the conditions with sum = 6.
```

**Example 2:**
```
Input: n = 6, index = 1, maxSum = 10
Output: 3
Explanation: nums = [2, 3, 2, 1, 1, 1] has sum = 10.
```

---

## Constraints

- `1 <= n <= maxSum <= 10^9`
- `0 <= index < n`
