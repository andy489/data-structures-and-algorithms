# 3901. Good Subsequence Queries

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/good-subsequence-queries/

## Problem

You are given an integer array `nums` of length `n` and an integer `p`.

A **non-empty subsequence** of `nums` is called **good** if:
- Its length is **strictly less** than `n`.
- The **greatest common divisor (GCD)** of its elements is **exactly** `p`.

You are also given a 2D integer array `queries` of length `q`, where each `queries[i] = [ind_i, val_i]` indicates that you should update `nums[ind_i]` to `val_i`.

After each query, determine whether there exists **any good subsequence** in the current array.

Return the **number** of queries for which a **good subsequence** exists.

## Examples

**Example 1:**
```
Input: nums = [4,8,12,16], p = 2, queries = [[0,3],[2,6]]
Output: 1

Explanation:
- After query [0,3]: nums = [3,8,12,16]. No subsequence has GCD exactly p=2.
- After query [2,6]: nums = [3,8,6,16]. Subsequence [8,6] has GCD exactly p=2.
Answer = 1.
```

**Example 2:**
```
Input: nums = [4,5,7,8], p = 3, queries = [[0,6],[1,9],[2,3]]
Output: 2
```

**Example 3:**
```
Input: nums = [5,7,9], p = 2, queries = [[1,4],[2,8]]
Output: 0
```

## Constraints

- `2 <= n == nums.length <= 5 * 10^4`
- `1 <= nums[i] <= 5 * 10^4`
- `1 <= queries.length <= 5 * 10^4`
- `queries[i] = [ind_i, val_i]`
- `1 <= val_i, p <= 5 * 10^4`
- `0 <= ind_i <= n - 1`
