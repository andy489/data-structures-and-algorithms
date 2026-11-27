# 3903. Smallest Stable Index I

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/smallest-stable-index-i/

## Problem

You are given an integer array `nums` of length `n` and an integer `k`.

For each index `i`, define its **instability score** as `max(nums[0..i]) - min(nums[i..n-1])`.

In other words:
- `max(nums[0..i])` is the **largest** value among the elements from index 0 to index `i`.
- `min(nums[i..n-1])` is the **smallest** value among the elements from index `i` to index `n-1`.

An index `i` is called **stable** if its instability score is **less than or equal to** `k`.

Return the **smallest** stable index. If no such index exists, return -1.

## Examples

**Example 1:**
```
Input: nums = [5,0,1,4], k = 3
Output: 3

Explanation:
- At index 0: max([5]) - min([5,0,1,4]) = 5 - 0 = 5
- At index 1: max([5,0]) - min([0,1,4]) = 5 - 0 = 5
- At index 2: max([5,0,1]) - min([1,4]) = 5 - 1 = 4
- At index 3: max([5,0,1,4]) - min([4]) = 5 - 4 = 1 <= k=3. Answer is 3.
```

**Example 2:**
```
Input: nums = [3,2,1], k = 1
Output: -1
```

**Example 3:**
```
Input: nums = [0], k = 0
Output: 0
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 10^9`
- `0 <= k <= 10^9`
