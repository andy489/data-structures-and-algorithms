# 3862. Find the Smallest Balanced Index

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/find-the-smallest-balanced-index/

## Problem

You are given an integer array `nums`.

An index `i` is **balanced** if the sum of elements strictly to the left of `i` equals the product of elements strictly to the right of `i`.

If there are no elements to the left, the sum is considered as `0`. Similarly, if there are no elements to the right, the product is considered as `1`.

Return an integer denoting the smallest balanced index. If no balanced index exists, return `-1`.

## Examples

**Example 1:**
```
Input: nums = [2,1,2]
Output: 1
Explanation: For index i = 1: left sum = 2, right product = 2. They are equal.
```

**Example 2:**
```
Input: nums = [2,8,2,2,5]
Output: 2
Explanation: For index i = 2: left sum = 2 + 8 = 10, right product = 2 * 5 = 10.
```

**Example 3:**
```
Input: nums = [1]
Output: -1
Explanation: No balanced index exists.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
