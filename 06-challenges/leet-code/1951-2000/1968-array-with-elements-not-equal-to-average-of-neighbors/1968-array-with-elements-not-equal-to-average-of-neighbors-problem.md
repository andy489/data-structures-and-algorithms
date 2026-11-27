# 1968. Array With Elements Not Equal to Average of Neighbors

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/

## Description

You are given a 0-indexed array nums of distinct integers. You want to rearrange the elements in the array such that every element in the rearranged array is not equal to the average of its neighbors.

More formally, the rearranged array should have the property such that for every i in the range 1 <= i < nums.length - 1, (nums[i-1] + nums[i+1]) / 2 is not equal to nums[i].

Return any rearrangement of nums that meets the requirements.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: [1,2,4,5,3]
```

**Example 2:**
```
Input: nums = [6,2,0,9,7]
Output: [9,7,6,2,0]
```

## Constraints

- 3 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^5
