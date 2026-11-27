# 3357. Minimize the Maximum Adjacent Element Difference

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/

---

## Problem Statement

You are given an array of integers `nums`. Some values in `nums` are **missing** and are denoted by -1.

You must choose a pair of **positive** integers `(x, y)` **exactly once** and replace each missing element with either `x` or `y`.

You need to **minimize** the **maximum** **absolute difference** between adjacent elements of `nums` after replacements.

Return the **minimum** possible difference.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,-1,10,8]
Output: 4
```
By choosing the pair (6, 7), nums becomes [1, 2, 6, 10, 8].
Adjacent differences: |1-2|=1, |2-6|=4, |6-10|=4, |10-8|=2. Maximum is 4.

**Example 2:**
```
Input:  nums = [-1,-1,-1]
Output: 0
```
By choosing (4, 4), nums becomes [4, 4, 4]. Maximum difference is 0.

**Example 3:**
```
Input:  nums = [-1,10,-1,8]
Output: 1
```
By choosing (11, 9), nums becomes [11, 10, 9, 8]. Maximum difference is 1.

---

## Constraints

- `2 <= nums.length <= 10^5`
- `nums[i]` is either -1 or in the range `[1, 10^9]`.
