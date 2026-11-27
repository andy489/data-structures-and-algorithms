# 2206. Divide Array Into Equal Pairs

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/divide-array-into-equal-pairs/

## Problem

You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:
- Each element belongs to exactly one pair.
- The elements present in a pair are equal.

Return true if nums can be divided into n pairs, otherwise return false.

## Examples

**Example 1:**
```
Input: nums = [3,2,3,2,2,2]
Output: true
Explanation: If nums is divided into the pairs (2,2), (3,3), and (2,2), it will satisfy all the conditions.
```

**Example 2:**
```
Input: nums = [1,2,3,4]
Output: false
```

## Constraints

- nums.length == 2 * n
- 1 <= n <= 500
- 1 <= nums[i] <= 500
