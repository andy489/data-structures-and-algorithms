# 3859. Count Subarrays With K Distinct Integers

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/

## Problem

You are given an integer array `nums` and two integers `k` and `m`.

Return an integer denoting the count of subarrays of `nums` such that:

- The subarray contains **exactly** `k` distinct integers.
- Within the subarray, each distinct integer appears **at least** `m` times.

## Examples

**Example 1:**
```
Input: nums = [1,2,1,2,2], k = 2, m = 2
Output: 2
Explanation:
- [1, 2, 1, 2]: {1: 2, 2: 2} — 2 distinct, each at least 2 times.
- [1, 2, 1, 2, 2]: {1: 2, 2: 3} — 2 distinct, each at least 2 times.
```

**Example 2:**
```
Input: nums = [3,1,2,4], k = 2, m = 1
Output: 3
Explanation:
- [3, 1]: {3: 1, 1: 1}
- [1, 2]: {1: 1, 2: 1}
- [2, 4]: {2: 1, 4: 1}
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
- `1 <= k, m <= nums.length`
