# 3467. Transform Array by Parity

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/transform-array-by-parity/

---

## Problem Statement

You are given an integer array `nums`. Transform `nums` by performing the following operations in the **exact** order specified:

1. Replace each even number with 0.
2. Replace each odd number with 1.
3. Sort the modified array in **non-decreasing** order.

Return the resulting array after performing these operations.

---

## Examples

**Example 1:**
```
Input: nums = [4,3,2,1]
Output: [0,0,1,1]
```

**Example 2:**
```
Input: nums = [1,5,1,4,2]
Output: [0,0,1,1,1]
```

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 1000`
