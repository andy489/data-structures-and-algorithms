# 3880. Minimum Absolute Difference Between Two Values

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-absolute-difference-between-two-values/

## Problem

You are given an integer array `nums` consisting only of 0, 1, and 2.

A pair of indices `(i, j)` is called **valid** if `nums[i] == 1` and `nums[j] == 2`.

Return the **minimum** absolute difference between `i` and `j` among all valid pairs. If no valid pair exists, return -1.

The absolute difference between indices `i` and `j` is defined as `abs(i - j)`.

## Examples

**Example 1:**
```
Input: nums = [1,0,0,2,0,1]
Output: 2
Explanation:
Valid pairs: (0,3) with diff 3, (5,3) with diff 2.
Answer is 2.
```

**Example 2:**
```
Input: nums = [1,0,1,0]
Output: -1
Explanation: No 2 in array, so no valid pair.
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 2`
