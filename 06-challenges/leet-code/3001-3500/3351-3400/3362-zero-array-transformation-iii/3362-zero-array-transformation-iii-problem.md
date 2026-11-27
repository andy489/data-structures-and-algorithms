# 3362. Zero Array Transformation III

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-iii/

---

## Problem Statement

You are given an integer array `nums` of length `n` and a 2D array `queries` where `queries[i] = [li, ri]`.

Each `queries[i]` represents the following action on `nums`:

- Decrement the value at each index in the range `[li, ri]` in `nums` by **at most** 1.
- The amount by which the value is decremented can be chosen **independently** for each index.

A **Zero Array** is an array with all its elements equal to 0.

Return the **maximum** number of elements that can be removed from `queries`, such that `nums` can still be converted to a **zero array** using the remaining queries. If it is not possible to convert `nums` to a zero array, return -1.

---

## Examples

**Example 1:**
```
Input:  nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
Output: 1
```
Remove queries[2]; the first two queries suffice to zero the array.

**Example 2:**
```
Input:  nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]
Output: 2
```
Remove queries[2] and queries[3].

**Example 3:**
```
Input:  nums = [1,2,3,4], queries = [[0,3]]
Output: -1
```
Cannot zero the array even using all queries.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `0 <= li <= ri < nums.length`
