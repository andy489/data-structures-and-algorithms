# 3927. Minimize Array Sum Using Divisible Replacements

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/

## Problem

You are given an integer array `nums`.

You can perform the following operation any number of times:

- Choose two indices `a` and `b` such that `nums[a] % nums[b] == 0`.
- Replace `nums[a]` with `nums[b]`.

Return the **minimum** possible sum of the array after performing any number of operations.

## Examples

**Example 1:**

```
Input: nums = [3,6,2]
Output: 7
Explanation: Replace nums[1]=6 with nums[2]=2 (since 6%2==0). Array: [3,2,2]. Sum=7.
```

**Example 2:**

```
Input: nums = [4,2,8,3]
Output: 9
Explanation: Replace 4 with 2, replace 8 with 2. Array: [2,2,2,3]. Sum=9.
```

**Example 3:**

```
Input: nums = [7,5,9]
Output: 21
Explanation: No pair satisfies the condition. Sum remains 21.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
