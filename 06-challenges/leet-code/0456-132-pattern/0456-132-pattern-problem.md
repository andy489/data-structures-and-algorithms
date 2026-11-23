# 456. 132 Pattern

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/132-pattern/

---

## Problem Statement

Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return `true` if there is a **132 pattern** in `nums`, otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,4]
Output: false
```

**Example 2:**
```
Input:  nums = [3,1,4,2]
Output: true
```

**Example 3:**
```
Input:  nums = [-1,3,2,0]
Output: true
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 2 * 10^5`
- `-10^9 <= nums[i] <= 10^9`
