# 2905. Find Indices With Index and Value Difference II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/

---

## Problem Statement

You are given a **0-indexed** integer array `nums` having length `n`, an integer `indexDifference`, and an integer `valueDifference`.

Your task is to find **two** indices `i` and `j`, both in the range `[0, n - 1]`, that satisfy the following conditions:

- `abs(i - j) >= indexDifference`, and
- `abs(nums[i] - nums[j]) >= valueDifference`

Return an integer array `answer`, where `answer = [i, j]` if there are two such indices, and `answer = [-1, -1]` otherwise. If there are multiple choices for the two indices, return any of them.

**Note:** `i` and `j` may be **equal**.

---

## Examples

**Example 1:**
```
Input: nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
Output: [0,3]
```

**Example 2:**
```
Input: nums = [2,1], indexDifference = 0, valueDifference = 0
Output: [0,0]
```

**Example 3:**
```
Input: nums = [1,2,3], indexDifference = 2, valueDifference = 4
Output: [-1,-1]
```

---

## Constraints

- `1 <= n == nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`
- `0 <= indexDifference <= 10^5`
- `0 <= valueDifference <= 10^9`
