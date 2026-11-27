# 3886. Sum of Sortable Integers

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-sortable-integers/

## Problem

You are given an integer array `nums` of length `n`.

An integer `k` is called **sortable** if `k` **divides** `n` and you can sort `nums` in **non-decreasing** order by sequentially performing the following operations:
- Partition `nums` into **consecutive subarrays** of length `k`.
- **Cyclically rotate each subarray independently** any number of times to the left or to the right.

Return an integer denoting the sum of all possible sortable integers `k`.

## Examples

**Example 1:**
```
Input: nums = [3,1,2]
Output: 3
Explanation:
- k=1: no rotation can sort the array.
- k=3: [3,1,2] can be rotated once to [1,2,3]. Sortable!
Only k=3 is sortable. Answer = 3.
```

**Example 2:**
```
Input: nums = [7,6,5]
Output: 0
```

**Example 3:**
```
Input: nums = [5,8]
Output: 3
Explanation: [5,8] is sorted, so k=1 and k=2 both work. Answer = 1+2 = 3.
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
