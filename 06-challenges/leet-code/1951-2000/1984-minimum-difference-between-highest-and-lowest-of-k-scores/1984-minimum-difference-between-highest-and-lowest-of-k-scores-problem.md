# 1984. Minimum Difference Between Highest and Lowest of K Scores

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

## Problem

You are given a 0-indexed integer array `nums`, where `nums[i]` represents the score of the `i`th student. You are also given an integer `k`.

Pick the scores of any `k` students from the array so that the difference between the highest and the lowest of the `k` scores is minimized.

Return the minimum possible difference.

## Examples

**Example 1:**
```
Input: nums = [90], k = 1
Output: 0
```

**Example 2:**
```
Input: nums = [9,4,1,7], k = 2
Output: 2
```

## Constraints

- `1 <= k <= nums.length <= 1000`
- `0 <= nums[i] <= 10^5`
