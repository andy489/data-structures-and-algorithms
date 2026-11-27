# 3866. First Unique Even Element

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/first-unique-even-element/

## Problem

You are given an integer array `nums`.

Return an integer denoting the **first even integer** (earliest by array index) that appears **exactly once** in `nums`. If no such integer exists, return `-1`.

An integer `x` is considered even if it is divisible by 2.

## Examples

**Example 1:**
```
Input: nums = [3,4,2,5,4,6]
Output: 2
Explanation: Both 2 and 6 are even and appear exactly once. Since 2 occurs first, the answer is 2.
```

**Example 2:**
```
Input: nums = [4,4]
Output: -1
Explanation: No even integer appears exactly once.
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
