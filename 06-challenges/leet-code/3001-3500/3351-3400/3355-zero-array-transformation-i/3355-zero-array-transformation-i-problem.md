# 3355. Zero Array Transformation I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-i/

---

## Problem Statement

You are given an integer array `nums` of length `n` and a 2D array `queries`, where `queries[i] = [li, ri]`.

For each `queries[i]`:

- Select a subset of indices within the range `[li, ri]` in `nums`.
- Decrement the values at the selected indices by 1.

A **Zero Array** is an array where all elements are equal to 0.

Return `true` if it is possible to transform `nums` into a **Zero Array** after processing all the queries sequentially, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,0,1], queries = [[0,2]]
Output: true
```
Select indices [0,2] and decrement. Array becomes [0,0,0].

**Example 2:**
```
Input:  nums = [4,3,2,1], queries = [[1,3],[0,2]]
Output: false
```
After all queries, the array becomes [3,1,0,0], which is not a Zero Array.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `0 <= li <= ri < nums.length`
