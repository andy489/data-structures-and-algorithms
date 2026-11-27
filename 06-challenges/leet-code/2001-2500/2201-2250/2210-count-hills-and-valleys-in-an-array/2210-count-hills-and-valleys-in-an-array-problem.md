# 2210. Count Hills and Valleys in an Array

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

## Problem

You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.

Return the number of hills and valleys in nums.

## Examples

**Example 1:**
```
Input: nums = [2,4,1,1,6,5]
Output: 3
Explanation: Index 1 (value 4) is a hill. Indices 2,3 (value 1) form a valley. Index 4 (value 6) is a hill.
```

**Example 2:**
```
Input: nums = [6,6,5,5,4,1]
Output: 0
```

## Constraints

- 3 <= nums.length <= 100
- 1 <= nums[i] <= 100
