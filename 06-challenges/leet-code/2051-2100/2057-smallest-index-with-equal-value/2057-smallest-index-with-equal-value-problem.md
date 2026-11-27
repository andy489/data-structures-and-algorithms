# 2057. Smallest Index With Equal Value

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/smallest-index-with-equal-value/

---

## Problem Statement

Given a 0-indexed integer array `nums`, return the **smallest** index `i` of `nums` such that `i mod 10 == nums[i]`, or `-1` if no such index exists.

---

## Examples

**Example 1:**
```
Input:  nums = [0,1,2]
Output: 0
```
Explanation: 0 mod 10 = 0 = nums[0].

**Example 2:**
```
Input:  nums = [4,3,2,1]
Output: 2
```
Explanation: 2 mod 10 = 2 = nums[2].

**Example 3:**
```
Input:  nums = [1,2,3,4,5,6,7,8,9,0]
Output: -1
```

---

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 9`
