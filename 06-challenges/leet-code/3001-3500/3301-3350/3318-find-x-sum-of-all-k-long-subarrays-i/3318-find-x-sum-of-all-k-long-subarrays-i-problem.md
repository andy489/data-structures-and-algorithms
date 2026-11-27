# 3318. Find X-Sum of All K-Long Subarrays I

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

## Problem

You are given an array `nums` of `n` integers and two integers `k` and `x`.

The **x-sum** of an array is calculated by the following procedure:
- Count the occurrences of all elements in the array.
- Keep only the occurrences of the top `x` most frequent elements. If two elements have the same number of occurrences, the element with the **bigger** value is considered more frequent.
- Calculate the sum of the resulting array.

**Note** that if an array has less than `x` distinct elements, its **x-sum** is the sum of the array.

Return an integer array `answer` of length `n - k + 1` where `answer[i]` is the **x-sum** of the subarray `nums[i..i + k - 1]`.

## Examples

**Example 1:**
```
Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
Output: [6,10,12]
```

**Example 2:**
```
Input: nums = [3,8,7,8,7,5], k = 2, x = 2
Output: [11,15,15,15,12]
```

## Constraints

- `1 <= n == nums.length <= 50`
- `1 <= nums[i] <= 50`
- `1 <= x <= k <= nums.length`
