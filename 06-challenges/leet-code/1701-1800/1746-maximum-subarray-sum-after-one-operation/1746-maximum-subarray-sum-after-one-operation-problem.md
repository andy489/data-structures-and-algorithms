# 1746. Maximum Subarray Sum After One Operation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/

---

## Problem Statement

You are given an integer array `nums`. You must perform **exactly one** operation where you can replace one element `nums[i]` with `nums[i] * nums[i]`.

Return the **maximum** possible subarray sum after **exactly one** such operation. The subarray must be non-empty.

---

## Examples

**Example 1:**
```
Input: nums = [2,-1,-4,-3]
Output: 17
Explanation: Square nums[2] to get 16. nums = [2,-1,16,-3]. The maximum subarray sum is [2,-1,16] = 17.
```

**Example 2:**
```
Input: nums = [1,-1,1,1,-1,-1,1]
Output: 4
Explanation: Square nums[1] to get 1. nums = [1,1,1,1,-1,-1,1]. Max subarray sum = [1,1,1,1] = 4.
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
