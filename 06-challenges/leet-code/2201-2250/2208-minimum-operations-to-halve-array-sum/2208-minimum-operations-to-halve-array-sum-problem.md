# 2208. Minimum Operations to Halve Array Sum

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimum-operations-to-halve-array-sum/

## Problem

You are given an array nums of positive integers. In one operation, you can choose any number from nums and reduce it to exactly half the number. (Note that you may choose this reduced number in future operations.)

Return the minimum number of operations to reduce the sum of nums by at least half.

## Examples

**Example 1:**
```
Input: nums = [5,19,8,1]
Output: 3
Explanation: The initial sum is 33. 
After 3 operations: [5, 4.75, 4, 1] with sum 14.75. 
14.75 <= 33/2 = 16.5.
```

**Example 2:**
```
Input: nums = [3,8,20]
Output: 3
```

## Constraints

- 1 <= nums.length <= 10⁵
- 1 <= nums[i] <= 10⁷
