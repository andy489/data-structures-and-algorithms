# 442. Find All Duplicates in an Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-all-duplicates-in-an-array/

---

## Problem Statement

Given an integer array `nums` of length `n` where all integers are in `[1, n]` and each integer appears **once** or **twice**, return an array of all the integers that appear **twice**.

You must write an algorithm that runs in `O(n)` time and uses only constant extra space.

---

## Examples

**Example 1:**
```
Input:  nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
```

**Example 2:**
```
Input:  nums = [1,1,2]
Output: [1]
```

**Example 3:**
```
Input:  nums = [1]
Output: []
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10^5`
- `1 <= nums[i] <= n`
- Each value in `nums` appears **once** or **twice**.
