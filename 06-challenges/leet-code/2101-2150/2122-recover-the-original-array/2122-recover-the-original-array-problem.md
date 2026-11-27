# 2122. Recover the Original Array

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/recover-the-original-array/

## Problem

Alice had a 0-indexed array `arr` consisting of `n` positive integers. She chose an arbitrary positive integer `k` and created two new 0-indexed integer arrays `lower` and `higher` in the following manner:

- `lower[i] = arr[i] - k`, for every index `i` where `0 <= i < n`
- `higher[i] = arr[i] + k`, for every index `i` where `0 <= i < n`

Unfortunately, Alice lost all three arrays. However, she remembers the integers that were present in the arrays `lower` and `higher`, but not the array each integer belonged to. Help Alice and recover the original array.

Given an array `nums` consisting of `2n` integers, where exactly `n` of the integers were present in `lower` and the remaining in `higher`, return the original array `arr`. In case the answer is not unique, return any valid array.

**Note:** The test cases are generated such that there exists at least one valid array `arr`.

## Examples

**Example 1:**
```
Input: nums = [2,10,6,4,8,12]
Output: [3,7,11]
Explanation: arr = [3,7,11], k = 1 → lower = [2,6,10], higher = [4,8,12].
```

**Example 2:**
```
Input: nums = [1,1,3,3]
Output: [2,2]
Explanation: arr = [2,2], k = 1 → lower = [1,1], higher = [3,3].
```

**Example 3:**
```
Input: nums = [5,435]
Output: [220]
Explanation: arr = [220], k = 215 → lower = [5], higher = [435].
```

## Constraints

- `2 * n == nums.length`
- `1 <= n <= 1000`
- `1 <= nums[i] <= 10^9`
- The test cases are generated such that there exists at least one valid array `arr`.
