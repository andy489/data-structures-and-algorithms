# 1005. Maximize Sum Of Array After K Negations

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, modify the array in the following way:

- Choose an index `i` and replace `nums[i]` with `-nums[i]`.

You should apply this process exactly `k` times. You may choose the same index `i` multiple times.

Return the largest possible sum of the array after modifying it in this way.

---

## Examples

**Example 1:**
```
Input:  nums = [4,2,3], k = 1
Output: 5
```

**Example 2:**
```
Input:  nums = [3,-1,0,2], k = 3
Output: 6
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-100 <= nums[i] <= 100`
- `1 <= k <= 10^4`
