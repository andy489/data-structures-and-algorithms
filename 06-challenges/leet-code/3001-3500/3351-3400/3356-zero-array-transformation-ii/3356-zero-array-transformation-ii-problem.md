# 3356. Zero Array Transformation II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-ii/

---

## Problem Statement

You are given an integer array `nums` of length `n` and a 2D array `queries` where `queries[i] = [li, ri, vali]`.

Each `queries[i]` represents the following action on `nums`:

- Decrement the value at each index in the range `[li, ri]` in `nums` by **at most** `vali`.
- The amount by which each value is decremented can be chosen **independently** for each index.

A **Zero Array** is an array with all its elements equal to 0.

Return the **minimum** possible **non-negative** value of `k`, such that after processing the first `k` queries in **sequence**, `nums` becomes a **Zero Array**. If no such `k` exists, return -1.

---

## Examples

**Example 1:**
```
Input:  nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
Output: 2
```
After 2 queries each covering [0,2] with val=1, the array becomes [0,0,0].

**Example 2:**
```
Input:  nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
Output: -1
```
Even after both queries, nums[0] = 3 remains non-zero.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 5 * 10^5`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 3`
- `0 <= li <= ri < nums.length`
- `1 <= vali <= 5`
