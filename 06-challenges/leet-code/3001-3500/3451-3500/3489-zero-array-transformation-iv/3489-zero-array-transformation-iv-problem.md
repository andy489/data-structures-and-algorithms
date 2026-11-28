# 3489. Zero Array Transformation IV

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-iv/

---

## Problem Statement

You are given an integer array `nums` of length `n` and a 2D array `queries`, where `queries[i] = [li, ri, vali]`.

Each `queries[i]` represents the following action on `nums`:

- Select a subset of indices in the range `[li, ri]` from `nums`.
- Decrement the value at each selected index by exactly `vali`.

A **Zero Array** is an array with all its elements equal to 0.

Return the **minimum** possible **non-negative** value of `k`, such that after processing the first `k` queries in **sequence**, `nums` becomes a **Zero Array**. If no such `k` exists, return -1.

---

## Examples

**Example 1:**
```
Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
Output: 2
```

**Example 2:**
```
Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
Output: -1
```

**Example 3:**
```
Input: nums = [1,2,3,2,1], queries = [[0,1,1],[1,2,1],[2,3,2],[3,4,1],[4,4,1]]
Output: 4
```

---

## Constraints

- `1 <= nums.length <= 10`
- `0 <= nums[i] <= 1000`
- `1 <= queries.length <= 1000`
- `queries[i] = [li, ri, vali]`
- `0 <= li <= ri < nums.length`
- `1 <= vali <= 1000`
