# 1982. Find Array Given Subset Sums

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/find-array-given-subset-sums/

## Problem

You are given an integer `n` representing the length of an unknown array that you are trying to recover. You are also given an array `sums` containing the values of all `2^n` subset sums of the unknown array (in no particular order).

Return the array `ans` of length `n` representing the unknown array. If multiple answers exist, return any of them.

An array `sub` is a subset of an array `arr` if `sub` can be obtained from `arr` by deleting some (possibly zero or all) elements of `arr`. The sum of the elements in `sub` is one possible subset sum of `arr`. The sum of an empty array is considered to be `0`.

## Examples

**Example 1:**
```
Input: n = 3, sums = [-3,-2,-1,0,0,1,2,3]
Output: [1,2,-3]
```

**Example 2:**
```
Input: n = 2, sums = [0,0,0,0]
Output: [0,0]
```

**Example 3:**
```
Input: n = 4, sums = [0,0,5,5,4,-1,4,9,9,-1,4,3,4,8,3,8]
Output: [0,-1,4,5]
```

## Constraints

- `1 <= n <= 15`
- `sums.length == 2^n`
- `-10^4 <= sums[i] <= 10^4`
