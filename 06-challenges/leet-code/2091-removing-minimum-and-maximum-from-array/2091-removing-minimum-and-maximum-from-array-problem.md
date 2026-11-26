# 2091. Removing Minimum and Maximum From Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

---

## Problem Statement

Given a 0-indexed array `nums`, remove both the minimum and maximum values. Each removal costs one operation. You can remove from either end. Return minimum operations needed.

---

## Examples

**Example 1:**
```
Input:  nums = [2,10,7,10,1,1,10,9,2]
Output: 5
```
Explanation: Min at idx 4, max at idx 1 or 2 or 6. Remove 5 from left: covers both.

**Example 2:**
```
Input:  nums = [0,-4,19,1,8,-2,-3,5]
Output: 3
```

**Example 3:**
```
Input:  nums = [101]
Output: 1
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^5 <= nums[i] <= 10^5`
