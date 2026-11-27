# 3347. Maximum Frequency of an Element After Performing Operations II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/

## Problem

You are given an integer array `nums` and two integers `k` and `numOperations`.

You must perform an **operation** `numOperations` times on `nums`, where in each operation you:
- Select an index `i` that was **not** selected in any previous operations.
- Add an integer in the range `[-k, k]` to `nums[i]`.

Return the **maximum** possible frequency of any element in `nums` after performing the **operations**.

## Examples

**Example 1:**
```
Input: nums = [1,4,5], k = 1, numOperations = 2
Output: 2
Explanation:
- Adding 0 to nums[1], after which nums becomes [1, 4, 5].
- Adding -1 to nums[2], after which nums becomes [1, 4, 4].
```

**Example 2:**
```
Input: nums = [5,11,20,20], k = 5, numOperations = 1
Output: 2
Explanation:
- Adding 0 to nums[1].
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `0 <= k <= 10^9`
- `0 <= numOperations <= nums.length`
