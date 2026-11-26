# 414. Third Maximum Number

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/third-maximum-number/

---

## Problem Statement

Given an integer array `nums`, return the **third distinct maximum** number in this array. If the third maximum does not exist, return the **maximum** number.

---

## Examples

**Example 1:**
```
Input:  nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.
```

**Example 2:**
```
Input:  nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```

**Example 3:**
```
Input:  nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third distinct maximum.
Both numbers with value 2 are considered as the same maximum. The third maximum is 1.
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
