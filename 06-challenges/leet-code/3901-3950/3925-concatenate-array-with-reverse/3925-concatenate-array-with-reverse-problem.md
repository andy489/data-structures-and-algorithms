# 3925. Concatenate Array With Reverse

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/concatenate-array-with-reverse/

## Problem

You are given an integer array `nums` of length `n`.

Construct a new array `ans` of length `2 * n` such that the first `n` elements are the same as `nums`, and the next `n` elements are the elements of `nums` in reverse order.

Formally, for `0 <= i <= n - 1`:
- `ans[i] = nums[i]`
- `ans[i + n] = nums[n - i - 1]`

Return an integer array `ans`.

## Examples

**Example 1:**

```
Input: nums = [1,2,3]
Output: [1,2,3,3,2,1]
```

**Example 2:**

```
Input: nums = [1]
Output: [1,1]
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
