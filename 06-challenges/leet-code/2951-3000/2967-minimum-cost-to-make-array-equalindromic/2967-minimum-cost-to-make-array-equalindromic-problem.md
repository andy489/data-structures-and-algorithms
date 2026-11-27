# 2967. Minimum Cost to Make Array Equalindromic

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/

## Problem

You are given an integer array nums.

In one operation, you may choose an index i and either increment or decrement nums[i] by 1.

Return the minimum number of operations required to make every element in nums equal to the same positive palindromic integer.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: 6
Explanation: Increment nums[0] twice and nums[1] once, then decrement nums[3] once and nums[4] twice. After 6 operations, nums becomes [3,3,3,3,3], and 3 is a positive palindromic integer.
It can be shown that this is the minimum number of operations required.
```

**Example 2:**
```
Input: nums = [10,12,13,14,15]
Output: 11
Explanation: Increment nums[0] once, then decrement nums[1], nums[2], nums[3], and nums[4] by 1, 2, 3, and 4, respectively. After 11 operations, nums becomes [11,11,11,11,11], and 11 is a positive palindromic integer.
It can be shown that this is the minimum number of operations required.
```

**Example 3:**
```
Input: nums = [22,33,22,33,22]
Output: 22
Explanation: Decrement nums[1] and nums[3] by 11 each. After 22 operations, nums becomes [22,22,22,22,22], and 22 is a positive palindromic integer.
It can be shown that this is the minimum number of operations required.
```

## Constraints

- `1 <= n <= 10^5`
- `1 <= nums[i] <= 10^9`
