# 2090. K-Radius Subarray Averages

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-radius-subarray-averages/

---

## Problem Statement

Given an array `nums` and integer `k`, for each center index `i`, compute the average of the subarray of radius k (i-k to i+k). If not enough elements, store -1.

---

## Examples

**Example 1:**
```
Input:  nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]
```

**Example 2:**
```
Input:  nums = [100000], k = 0
Output: [100000]
```

**Example 3:**
```
Input:  nums = [8], k = 100000
Output: [-1]
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10^5`
- `0 <= nums[i], k <= 10^5`
