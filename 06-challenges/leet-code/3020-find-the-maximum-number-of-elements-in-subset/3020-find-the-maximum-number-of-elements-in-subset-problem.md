# 3020. Find the Maximum Number of Elements in Subset

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

---

## Problem Statement

You are given an array of positive integers `nums`.

You need to select a subset of `nums` which satisfies the following condition:

You can place the selected elements in a sequence in the way: `[x, x^2, x^4, ..., x^(k/2), ..., x^2, x]` where every element appears exactly twice except the middle element. You may set `x = 1` to get `[1]` (length 1).

Return the maximum length of such a subset.

---

## Examples

**Example 1:**
```
Input:  nums = [5,4,1,2,2,4,1,5]
Output: 3
```

**Example 2:**
```
Input:  nums = [1,1,1,1]
Output: 4
```

---

## Constraints

- `2 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
