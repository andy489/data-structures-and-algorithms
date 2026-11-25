# 996. Number of Squareful Arrays

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-squareful-arrays/

---

## Problem Statement

An array is squareful if the sum of every pair of adjacent elements is a perfect square.

Given an integer array `nums`, return the number of permutations of `nums` that are squareful.

Two permutations `perm1` and `perm2` are different if there is some index `i` such that `perm1[i] != perm2[i]`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,17,8]
Output: 2
```

**Example 2:**
```
Input:  nums = [2,2,2]
Output: 1
```

---

## Constraints

- `1 <= nums.length <= 12`
- `0 <= nums[i] <= 10^9`
