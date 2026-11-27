# 698. Partition to K Equal Sum Subsets

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return `true` if it is possible to divide this array into `k` non-empty subsets whose sums are all equal.

---

## Examples

**Example 1:**
```
Input:  nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: Partitioning into [5], [1,4], [2,3], [2,3] is possible.
```

**Example 2:**
```
Input:  nums = [1,2,3,4], k = 3
Output: false
```

---

## Constraints

- `1 <= k <= nums.length <= 16`
- `1 <= nums[i] <= 10⁴`
- The frequency of each element is in the range `[1, 4]`.
