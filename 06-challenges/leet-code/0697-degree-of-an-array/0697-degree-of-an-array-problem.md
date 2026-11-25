# 697. Degree of an Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/degree-of-an-array/

---

## Problem Statement

Given a non-empty array of non-negative integers `nums`, the **degree** of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,2,3,1]
Output: 2
Explanation: The degree is 2, achieved by elements 1 and 2. 
The smallest subarray is [2,2] with length 2.
```

**Example 2:**
```
Input:  nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: The degree is 3 (for element 2). The subarray [2,2,3,1,4,2] has length 6.
```

---

## Constraints

- `nums.length` will be between 1 and 50,000.
- `nums[i]` will be an integer between 0 and 49,999.
